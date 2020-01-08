package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonDao {
    int insertPerson(Person person);
    List<Person> getPersons();
}
