package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataProvider {

    private static SessionFactory sessionFactory =null;

    private DataProvider() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            var configuration = new Configuration().configure();
            configuration.setProperty("hibernate.connection.username",System.getenv("DB_USER"));
            configuration.setProperty("hibernate.connection.password",System.getenv("DB_PASSWORD"));
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
