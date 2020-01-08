package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Person {
    private final String SSN;
    private final LocalDate dateOfBirth;
    private final String firstName;
    private final String lastName;
    private final boolean isAwesome;
    private final float awesomeness;
    private final BigDecimal wealth;

    public Person(@JsonProperty("SSN") String ssn, @JsonProperty("dateOfBirth") LocalDate dateOfBirth,
                  @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
                  @JsonProperty("isAwesome") boolean isAwesome, @JsonProperty("awesomeness") float awesomeness,
                  @JsonProperty("wealth") BigDecimal wealth) {
        this.SSN = ssn;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAwesome = isAwesome;
        this.awesomeness = awesomeness;
        this.wealth = wealth;
    }

    public String getSSN() {
        return SSN;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public float getAwesomeness() {
        return awesomeness;
    }

    public BigDecimal getWealth() {
        return wealth;
    }
}
