package de.akademie.swe.application.service;

import de.akademie.swe.core.domain.Person;

import java.util.List;

public interface GenericService <T> {
    T persist(T t);
    T getById(long id);
    List<T> getAll();
}