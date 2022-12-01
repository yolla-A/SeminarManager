package de.akademie.swe.core.service;

import de.akademie.swe.core.domain.Person;
import de.akademie.swe.core.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl {
    @Autowired
    private PersonRepository personRepository;
    public Person persistPerson(Person person){
        return personRepository.persist(person);
    }
}
