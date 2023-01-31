package de.akademie.swe.core.service;

import de.akademie.swe.application.service.PersonService;
import de.akademie.swe.core.domain.Person;
import de.akademie.swe.core.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person persist(Person person) {
        return personRepository.persist(person);
    }

    @Override
    public Person getById (long id) {
        return personRepository.getById(Person.class, id);
    }

    @Override
    public List<Person> getAll () {
        return personRepository.getAll(Person.class);
    }
}

/*
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person persistPerson(Person person) {
        return personRepository.persist(person);
    }

    @Override
    public Person getById(long id) {
        return personRepository.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    }
}*/

