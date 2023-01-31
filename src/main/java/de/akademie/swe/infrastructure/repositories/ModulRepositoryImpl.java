package de.akademie.swe.infrastructure.repositories;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.akademie.swe.core.domain.Modul;
import de.akademie.swe.core.repositories.ModulRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ModulRepositoryImpl extends AbstractRepository<Modul> implements ModulRepository {
}



/*@Repository
public class ModulRepositoryImpl implements ModulRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Modul persist(Modul modul){  //save modul
        Session session=this.sessionFactory.openSession();

        session.beginTransaction();


        session.persist(modul);
        session.flush();
        session.getTransaction().commit();

        return modul;
    }
}*/
