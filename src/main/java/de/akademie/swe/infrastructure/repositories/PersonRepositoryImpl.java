package de.akademie.swe.infrastructure.repositories;

import de.akademie.swe.core.domain.Person;
import de.akademie.swe.core.repositories.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import de.akademie.swe.core.domain.Person;
import de.akademie.swe.core.repositories.PersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl extends AbstractRepository<Person> implements PersonRepository { }

/*
@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Person persist(Person person) {


      //  opens a connection to database
        Session session = this.sessionFactory.openSession();

     //    starts a new transaction
        session.beginTransaction();

      //  persist the person
        session.persist(person);

        session.flush();

     //   commit transaction
        session.getTransaction().commit();
        return person;
    }*/
/*
    @Override
    public Person getById(Class<Person> c, long id) {
        return null;
    }

    @Override
    public List<Person> getAll(Class<Person> c) {
        return null;
    }

    @Override
    public Person getById (long id) {
        return this.sessionFactory.openSession().get(Person.class, id);
    }

    @Override
    public List<Person> getAll () {
        return this.sessionFactory.openSession().createQuery("SELECT a FROM Person a", Person.class).getResultList();
    }


}*/
