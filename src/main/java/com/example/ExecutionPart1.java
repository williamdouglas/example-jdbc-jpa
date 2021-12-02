package com.example;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class ExecutionPart1 {
    public static void main(String[] args) throws SQLException {
        startDatabase();

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        Estado estadoPAdd = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoPAdd = new Aluno("Pedro", 20, estadoPAdd);

        entityManager.getTransaction().begin();
        entityManager.persist(estadoPAdd);
        entityManager.persist(alunoPAdd);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: sa");
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
