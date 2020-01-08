package com.example.demo.service;

import com.example.demo.repository.PersonRepository;
import com.example.demo.dto.PersonDTO;
import com.example.demo.model.PersonBO;
import ma.glasnost.orika.BoundMapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final BoundMapperFacade<PersonDTO, PersonBO> mapper = new DefaultMapperFactory.Builder().build()
            .getMapperFacade(PersonDTO.class, PersonBO.class);

    @Autowired
    public PersonService(@Qualifier("personRepo") PersonRepository personRepo) {
        this.personRepository = personRepo;
    }

    public void addPerson(PersonDTO personDTO) {
        var person = PersonBO.createNew(personDTO.getSSN(), personDTO.getDateOfBirth(),
                personDTO.getFirstName(), personDTO.getLastName(), personDTO.isAwesome(),
                personDTO.getAwesomeness(), personDTO.getWealth());
        personRepository.insertPerson(person);
    }

    public List<PersonDTO> getAllPeople() {
        var people = personRepository.getAllPeople();
        return people.stream().map(mapper::mapReverse).collect(Collectors.toList());
    }
}
