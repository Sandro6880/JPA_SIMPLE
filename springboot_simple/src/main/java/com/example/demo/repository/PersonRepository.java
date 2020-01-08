package com.example.demo.repository;

import com.example.demo.model.PersonBO;

import java.util.List;

public interface PersonRepository {
    void insertPerson(PersonBO person);
    List<PersonBO> getAllPeople();
}
