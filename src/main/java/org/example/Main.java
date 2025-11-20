package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = DataProvider.getSessionFactory();


        User newUser = new User();
        newUser.setEmail("@@@");
        newUser.setPassword("password");

        Game newGame = new Game();
        newGame.setTitle("New Game");
        newGame.setDescription("New Game");
        newGame.setPlatform("New Game");

        newUser.addGame(newGame);

        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(newUser);
            session.getTransaction().commit();
        }

    }
}