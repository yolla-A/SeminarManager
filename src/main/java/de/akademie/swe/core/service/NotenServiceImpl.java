package de.akademie.swe.core.service;

import de.akademie.swe.application.service.NotenService;
import de.akademie.swe.core.domain.Note;
import de.akademie.swe.core.repositories.NotenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotenServiceImpl implements NotenService {

    @Autowired
    private NotenRepository notenRepository;

    @Override
    public Note persist(Note note) {
        return this.notenRepository.persist(note);
    }

    @Override
    public Note getById(long id) {
        return this.notenRepository.getById(Note.class, id);
    }

    @Override
    public List<Note> getAll() {
        return this.notenRepository.getAll(Note.class);
    }
}
