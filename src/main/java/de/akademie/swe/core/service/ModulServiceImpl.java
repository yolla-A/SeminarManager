package de.akademie.swe.core.service;

import de.akademie.swe.application.service.ModulService;
import de.akademie.swe.core.domain.Modul;
import de.akademie.swe.core.repositories.ModulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ModulServiceImpl implements ModulService {
    @Autowired
    private ModulRepository modulRepository;
    @Override
    public Modul persist (Modul modul){
        return this.modulRepository.persist(modul);
    }

    @Override
    public Modul getById (long id) {
        return modulRepository.getById(Modul.class, id);
    }

    @Override
    public List<Modul> getAll () {
        return modulRepository.getAll(Modul.class);
    }


}
