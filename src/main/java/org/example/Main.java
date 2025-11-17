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

        GameRepository gameRepository = new GameRepository(DataProvider.getSessionFactory());

        Game game = new Game();
        game.setTitle("Title");
        game.setPlatform("Platform");
        game.setDescription("Description");
        game.setYear(2018);

        System.out.println( gameRepository.findById(6L) );

        gameRepository.findAll().forEach(g -> {
            System.out.println(g.getTitle());
        });

        System.out.println(gameRepository.count());

        gameRepository.findById(7L).ifPresent(
                (g)-> gameRepository.delete(g)
        );

    }
}