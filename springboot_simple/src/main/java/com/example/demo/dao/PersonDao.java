package com.example.demo.dao;

//import com.example.demo.model.Person; -> ANSCHEINEND FALSCH -_- ???=?=?=?=
import com.example.demo.model.data.Person; // ----> INTELLLIJEEEYYY!! WTF!?!?!?!

import java.util.List;

public interface PersonDao {
    int insertPerson(Person person);
    List<Person> getPersons();
}
