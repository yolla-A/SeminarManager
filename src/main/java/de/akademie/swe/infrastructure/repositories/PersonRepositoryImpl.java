package de.akademie.swe.infrastructure.repositories;

import de.akademie.swe.core.domain.Person;
import de.akademie.swe.core.repositories.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Person persist(Person person) {
        /*opens a connection to database*/
        Session session = this.sessionFactory.openSession();

        /* starts a new transaction */
        session.beginTransaction();

        /*persist the person */
        session.persist(person);

        session.flush();

        /*commit transaction*/
        session.getTransaction().commit();
        return person;
    }

}
