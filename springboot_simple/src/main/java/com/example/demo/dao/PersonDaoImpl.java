package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

    private static List<Person> _persons = new ArrayList<Person>();

    @Override
    public int insertPerson(Person person) {
        _persons.add(person);
        return 0;
    }

}
