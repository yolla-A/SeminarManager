package de.akademie.swe.core.repositories;

import de.akademie.swe.core.domain.Person;

import java.util.List;

public interface PersonRepository extends GenericRepository<Person>{

}

/*public interface PersonRepository {

    Person persist(Person person); //fest zu machen, specheirn

    Person getById(long id);
    List<Person> getAll();

}*/
