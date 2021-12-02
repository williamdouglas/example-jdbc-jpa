package com.example;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class ExecutionPart2 {

    public static void main(String[] args) throws SQLException {
        startDatabase();

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Customer customer = new Customer();
        // customer.setFirstName("Dennys");
        // customer.setLastName("Fredericci");

        entityManager.getTransaction().begin();
        // entityManager.persist(customer);
        entityManager.getTransaction().commit();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: sa");

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}