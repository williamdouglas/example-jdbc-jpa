package com.example.part2;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Aluno;
import com.example.Estado;

public class ExecutionPart2 {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Estado estadoPAdd = new Estado("Espírito Santo", "ES");
        // Aluno alunoPAdd = new Aluno("Denis", 30, estadoPAdd);
        // Aluno alunoPAdd2 = new Aluno("João", 30, estadoPAdd);

        //Estado estado = entityManager.find(Estado.class, 1);
        Aluno aluno = entityManager.find(Aluno.class, 21);

        entityManager.getTransaction().begin();

        // entityManager.persist(estadoPAdd);
        // entityManager.persist(alunoPAdd);
        // entityManager.persist(alunoPAdd2);
        //entityManager.remove(estado);
        //entityManager.remove(aluno);
        aluno.setNome("Douglas");
        aluno.setIdade(40);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
