package org.example;

import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class GameRepository implements Repository<Game> {

    SessionFactory sessionFactory;

    public GameRepository(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

    @Override
    public Game save(Game entity) {
        return null;
    }

    @Override
    public Optional<Game> delete(Game entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Game> findById(Game entity) {
        return Optional.empty();
    }

    @Override
    public List<Game> findAll() {
        return List.of();
    }

    @Override
    public Long count() {
        return 0L;
    }
}
