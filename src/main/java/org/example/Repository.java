package org.example;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    T save(T entity);
    Optional<T> delete(T entity);

    Optional<T> findById(T entity);
    List<T> findAll();
    Long count();
}
