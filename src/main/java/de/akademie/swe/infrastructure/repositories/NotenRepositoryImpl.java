package de.akademie.swe.infrastructure.repositories;

import de.akademie.swe.core.domain.Note;
import de.akademie.swe.core.repositories.NotenRepository;
import org.springframework.stereotype.Repository;

@Repository
public class NotenRepositoryImpl extends AbstractRepository<Note> implements NotenRepository {
}