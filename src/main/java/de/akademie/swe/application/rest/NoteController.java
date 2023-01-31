package de.akademie.swe.application.rest;

import de.akademie.swe.application.rest.dto.NoteDto;
import de.akademie.swe.application.service.ModulService;
import de.akademie.swe.application.service.NotenService;
import de.akademie.swe.application.service.PersonService;
import de.akademie.swe.application.service.SeminarService;
import de.akademie.swe.core.domain.Modul;
import de.akademie.swe.core.domain.Note;
import de.akademie.swe.core.domain.Person;
import de.akademie.swe.core.domain.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NotenService notenService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ModulService modulService;

    @Autowired
    private SeminarService seminarService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note persist(@Valid @RequestBody NoteDto noteDto) {

        Modul modul = this.modulService.getById(noteDto.getModulId());
        Person person = this.personService.getById(noteDto.getPersonId());
        Seminar seminar = this.seminarService.getById(noteDto.getSeminarId());

        if (modul == null || person == null || seminar == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return notenService.persist(new Note(noteDto.getNote(), modul, person, seminar));

    }

    @GetMapping("{id}")
    public Note getById(@PathVariable Long id) {
        return this.notenService.getById(id);
    }

    @GetMapping
    public List<Note> getAll() {
        return this.notenService.getAll();
    }

}