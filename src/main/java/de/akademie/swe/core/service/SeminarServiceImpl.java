package de.akademie.swe.core.service;

import de.akademie.swe.application.service.SeminarService;

import de.akademie.swe.core.domain.Seminar;
import de.akademie.swe.core.repositories.SeminarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SeminarServiceImpl implements SeminarService {

    @Autowired
    private SeminarRepository seminarRepository;

    @Override
    public Seminar persist(Seminar seminar) {
        return this.seminarRepository.persist(seminar);
    }

    @Override
    public Seminar getById(long id) {
        return this.seminarRepository.getById(Seminar.class, id);
    }

    @Override
    public List<Seminar> getAll() {
        return this.seminarRepository.getAll(Seminar.class);
    }
}
/*public class SeminarServiceImpl implements SeminarService {
    @Autowired
    private SeminarRepository seminarRepository;

    public Seminar persistSeminar(Seminar seminar) {

        return seminarRepository.persist(seminar);
    }
}*/
