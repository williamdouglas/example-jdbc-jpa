package com.example.part1;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Aluno;
import com.example.Estado;

public class ExecutionPart1 {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Estado estadoPAdd = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoPAdd = new Aluno("Pedro", 20, estadoPAdd);

        entityManager.getTransaction().begin();
        entityManager.persist(estadoPAdd);
        entityManager.persist(alunoPAdd);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
