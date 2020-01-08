package com.example.demo.model.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Person extends EntityBase {
    @Id
    private String SSN;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private boolean isAwesome;
    private float awesomeness;
    private BigDecimal wealth;
    public Person(){

    }

    public Person(String ssn, LocalDate date_of_birth, String first_name, String last_name, boolean is_awesome, float awesomeness, BigDecimal wealth){}

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public float getAwesomeness() {
        return awesomeness;
    }

    public void setAwesomeness(float awesomeness) {
        this.awesomeness = awesomeness;
    }

    public BigDecimal getWealth() {
        return wealth;
    }

    public void setWealth(BigDecimal wealth) {
        this.wealth = wealth;
    }
}
