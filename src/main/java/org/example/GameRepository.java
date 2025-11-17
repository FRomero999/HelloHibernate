package org.example;

import org.hibernate.Session;
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
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
            return Optional.ofNullable(entity);
        }
    }

    @Override
    public Optional<Game> deleteById(Long id) {
        try(Session session=sessionFactory.openSession()){
            Game game = session.find(Game.class,id);
            if(game!=null){
                session.beginTransaction();
                session.remove(game);
                session.getTransaction().commit();
            }
            return Optional.ofNullable(game);
        }
    }

    @Override
    public Optional<Game> findById(Long id) {
        try(Session session=sessionFactory.openSession()){
            return Optional.ofNullable(session.find(Game.class, id));
        }
    }

    @Override
    public List<Game> findAll() {
        try(Session session=sessionFactory.openSession()){
            return session.createQuery("from Game",Game.class).list();
        }
    }

    @Override
    public Long count() {
        try(Session session=sessionFactory.openSession()){
            Long salida = session.createQuery("SELECT count(g) from Game g",Long.class).getSingleResult();
            return salida;
        }
    }
}
