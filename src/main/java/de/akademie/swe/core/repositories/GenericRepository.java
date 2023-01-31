package de.akademie.swe.core.repositories;


import java.util.List;

public interface GenericRepository <T> {
    T persist(T t);
    T getById(Class<T> c, long id);
    List<T> getAll(Class<T> c);
}