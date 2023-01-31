package de.akademie.swe.infrastructure.repositories;

import java.util.List;
import de.akademie.swe.core.repositories.GenericRepository;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.springframework.beans.factory.annotation.Autowired;

        import java.util.List;

abstract class AbstractRepository<T> implements GenericRepository<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T persist (T t) {

        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(t);
        session.flush();
        session.getTransaction().commit();

        return t;

    }

    @Override
    public T getById (Class<T> c, long id) {
        return c.cast(this.sessionFactory.openSession().get(c, id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll (Class<T> c) {
        return this.sessionFactory.openSession().createQuery("from " + c.getName()).getResultList();
    }
}

