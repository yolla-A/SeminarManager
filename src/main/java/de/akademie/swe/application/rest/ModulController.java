package de.akademie.swe.application.rest;

import de.akademie.swe.application.rest.dto.ModulDto;
import de.akademie.swe.application.service.ModulService;
import de.akademie.swe.core.domain.Modul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/modul")
public class ModulController {

    @Autowired
    private ModulService modulService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Modul persist(@Valid @RequestBody ModulDto modulDto) {
        return this.modulService.persist(new Modul(modulDto.getName(), modulDto.getNummer(), modulDto.getCp()));
    }

    @GetMapping("/modul")
    public String sayHallo() {
        return "ich bin der Controller ,der fuer die Module zustaendig ist";
    }

    @GetMapping("{id}")
    public Modul getById(@PathVariable Long id) {
        return this.modulService.getById(id);
    }

    @GetMapping
    public List<Modul> getAll() {
        return this.modulService.getAll();
    }
}




