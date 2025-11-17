package org.example;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    T save(T entity);
    Optional<T> delete(T entity);
    Optional<T> deleteById(Long id);

    Optional<T> findById(Long id);
    List<T> findAll();
    Long count();
}
