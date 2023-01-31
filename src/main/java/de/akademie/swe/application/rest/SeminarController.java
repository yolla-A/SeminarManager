package de.akademie.swe.application.rest;


import de.akademie.swe.application.rest.dto.ModulDto;
import de.akademie.swe.application.rest.dto.SeminarDto;
import de.akademie.swe.application.service.ModulService;
import de.akademie.swe.application.service.SeminarService;

import de.akademie.swe.core.domain.Modul;
import de.akademie.swe.core.domain.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/seminar")
public class SeminarController {
    @Autowired
    private SeminarService seminarService;
    @Autowired
    private ModulService modulService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seminar persist(@Valid @RequestBody SeminarDto seminarDto) {


        Modul modul = modulService.getById(seminarDto.getModulId());

        if (modul == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Seminar seminar = new Seminar(seminarDto.getNummer(), seminarDto.getName(), seminarDto.getStartdatum(), seminarDto.getEndedatum(), modul);

        return seminarService.persist(seminar);

    }


    @GetMapping("/hello")
    public String getHello() {
        return "Hello Yolla";
    }


    @GetMapping("{id}")
    public Seminar getById(@PathVariable Long id) {
        return this.seminarService.getById(id);
    }
    @GetMapping
    public List<Seminar> getAll() {
        return this.seminarService.getAll();
    }
    @PostMapping("/seminar")
    public Seminar persistSeminar(@ModelAttribute SeminarDto seminarDto, ModulDto modulDto) {

        //Modul python = new Modul("Data Sience", "4", 3);
        //Modul java = new Modul("Praktische Informatik", "3", 6);

//        Modul c=new Modul(modulDto.getName(), modulDto.getNummer(), modulDto.getCreditPoints());
//
        //this.seminarService.persistSeminar(seminar);
        return null;
    }

}

