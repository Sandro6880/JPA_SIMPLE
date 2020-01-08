package com.example.demo.model;

import com.example.demo.model.data.Person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonBO extends RootBO<Person>{

    public PersonBO(Person state) {
        super(state);
    }

    public static PersonBO createNew(String ssn, LocalDate dateOfBirth, String firstName, String lastName,
                                     boolean isAwesome, float awesomeness,
                                     BigDecimal wealth) {
        var pe = new Person();
        pe.setSSN(ssn);
        pe.setDateOfBirth(dateOfBirth);
        pe.setFirstName(firstName);
        pe.setLastName(lastName);
        pe.setAwesome(isAwesome);
        pe.setAwesomeness(awesomeness);
        pe.setWealth(wealth);
        return new PersonBO(pe);
    }

    public String getSSN() {
        return this.state.getSSN();
    }

    public LocalDate getDateOfBirth() {
        return this.state.getDateOfBirth();
    }

    public String getFirstName() {
        return this.state.getFirstName();
    }

    public String getLastName() {
        return this.state.getLastName();
    }

    public boolean isAwesome() {
        return this.state.isAwesome();
    }

    public float getAwesomeness() {
        return this.state.getAwesomeness();
    }

    public BigDecimal getWealth() {
        return this.state.getWealth();
    }
}
