package de.akademie.swe.application.rest;

import de.akademie.swe.application.rest.dto.PersonDto;
import de.akademie.swe.application.service.PersonService;
import de.akademie.swe.core.domain.Adresse;
import de.akademie.swe.core.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Person persist(@Valid @RequestBody PersonDto personDto) {

        Adresse adresse = new Adresse(personDto.getStrasse(), personDto.getPlz(), personDto.getOrt());
        Person person = new Person(personDto.getName(), personDto.getVorname(), personDto.getGeburtsdatum(), adresse);

        return personService.persist(person);

    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello Yolla";
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable Long id) {
        return this.personService.getById(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return this.personService.getAll();
    }

   /* @PostMapping("/person")
    public Person persistPerson(@ModelAttribute PersonDto personDto) {


        Adresse adresse = new Adresse("Strasse1", "12345", "Dorfhausen");
        Person person = new Person(personDto.getName(), personDto.getVorname(), personDto.geGeburtsdatum(), adresse);

        this.personService.persistPerson(person);
        return person;

        //return personService.persistPerson(person);
    }*/

   /* @GetMapping("/person/{id}")
    public Person getById(@PathVariable Long id) {
        return this.personService.getById(id);
    }

    @GetMapping("/person")
    public List<Person> getAll() {
        return this.personService.getAll();
    }*/

}