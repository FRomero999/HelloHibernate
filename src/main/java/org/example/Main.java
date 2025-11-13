package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        var hib = new Configuration().configure();
        SessionFactory factory = hib.buildSessionFactory();

        Game game = new Game();
        game.setTitle("Title");
        game.setPlatform("Platform");
        game.setDescription("Description");
        game.setYear(2018);

        factory.inTransaction((session) -> {
            session.persist(game);
        });



        try(Session session = factory.openSession()) {
            session.beginTransaction();
            Game g5 = session.find(Game.class, 5);
            System.out.println(g5);
            g5.setTitle("Ciberpun 207777777");
            session.merge(g5);
            session.getTransaction().commit();
            System.out.println(g5);
        }


        factory.inTransaction((session) -> {
            Game g = session.find(Game.class, 41);
            if(g != null) session.remove(g);
        });

        try(Session session = factory.openSession()) {
            List<Game> games = session.createQuery("from Game").list();
            games.forEach(System.out::println);
        }

        System.out.println("------------------------------------");
        factory.inSession( (session) -> {
            Query<Game> query = session.createQuery("from Game where year = :year");
            query.setParameter("year", 1998);
            List<Game> games = query.getResultList();
            games.forEach(System.out::println);
        });



    }
}