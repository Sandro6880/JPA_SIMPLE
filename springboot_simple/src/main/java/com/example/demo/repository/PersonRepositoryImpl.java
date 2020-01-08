package com.example.demo.repository;

import com.example.demo.model.PersonBO;
import com.example.demo.model.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository("personRepo")
public class PersonRepositoryImpl extends RepositoryBase<Person> implements PersonRepository {

    @Autowired
    public PersonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void insertPerson(PersonBO person) {
        persist(person);
    }

    @Override
    public List<PersonBO> getAllPeople() {
        var query = entityManager.createQuery("select p from Person p");
        List<Person> entities = query.getResultList();
        return entities.stream().map(PersonBO::new).collect(Collectors.toList());
    }

}
