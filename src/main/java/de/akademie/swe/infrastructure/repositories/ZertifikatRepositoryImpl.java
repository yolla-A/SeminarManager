package de.akademie.swe.infrastructure.repositories;

import de.akademie.swe.core.domain.Zertifikat;
import de.akademie.swe.core.repositories.ZertifikatRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ZertifikatRepositoryImpl extends AbstractRepository<Zertifikat> implements ZertifikatRepository {
}