package de.akademie.swe.infrastructure.repositories;


import de.akademie.swe.core.domain.Seminar;
import de.akademie.swe.core.repositories.SeminarRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import de.akademie.swe.core.domain.Seminar;
import de.akademie.swe.core.repositories.SeminarRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SeminarRepositoryImpl extends AbstractRepository<Seminar> implements SeminarRepository{

}

/*
@Repository
public class SeminarRepositoryImpl implements SeminarRepository {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Seminar persist(Seminar seminar) {
       //opens a connection to database/
        Session session = this.sessionFactory.openSession();

        // starts a new transaction /
        session.beginTransaction();

        //persist the person /
        session.persist(seminar);

        session.flush();

      //commit transaction
        session.getTransaction().commit();
        return seminar;
    }

}*/


