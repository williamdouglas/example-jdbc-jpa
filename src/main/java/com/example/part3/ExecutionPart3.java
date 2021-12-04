package com.example.part3;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Aluno;
import com.example.Estado;

public class ExecutionPart3 {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Estado estadoPAdd = new Estado("Bahia", "BA");
        // Aluno alunoPAdd = new Aluno("Denis", 25, estadoPAdd);
        // Aluno alunoPAdd2 = new Aluno("João", 30, estadoPAdd);

        // Estado estado = entityManager.find(Estado.class, 1);
        // Aluno aluno = entityManager.find(Aluno.class, 21);

        // entityManager.getTransaction().begin();

        // entityManager.persist(estadoPAdd);
        // entityManager.persist(alunoPAdd);
        // entityManager.persist(alunoPAdd2);
        // entityManager.remove(estado);
        // entityManager.remove(aluno);
        // aluno.setNome("Douglas");
        // aluno.setIdade(40);

        // entityManager.getTransaction().commit();

        // entityManager.close();
        // entityManagerFactory.close();

        // =====================================================================
        // SQL native

        String nome = "Douglas";

        // trazendo somente um aluno
        // String sql = "SELECT * FROM aluno WHERE nome = :nome";
        // Aluno alunoSQL = (Aluno) entityManager.createNativeQuery(sql,
        // Aluno.class).setParameter("nome", nome)
        // .getSingleResult();

        // trazendo uma lista de alunos
        // String sqlList = "SELECT * FROM aluno a";
        // List<Aluno> alunosSQL = entityManager.createNativeQuery(sqlList,
        // Aluno.class).getResultList();

        // String sqlList = "SELECT * FROM aluno WHERE estado_id = :idEstado";
        // List<Aluno> alunosSQL = entityManager.createNativeQuery(sqlList,
        // Aluno.class).setParameter("idEstado", 5)
        // .getResultList();

        // System.out.println("Consulta alunoSQL: " + alunoSQL);
        // alunosSQL.forEach(Aluno -> System.out.println("Consulta alunosSQL: " +
        // Aluno));

        // =====================================================================
        // JPQL

        // trazendo somente um aluno
        String jpql = "SELECT a FROM Aluno a WHERE nome = :nome";
        Aluno alunoJPQL = entityManager.createQuery(jpql,
        Aluno.class).setParameter("nome", nome)
        .getSingleResult();

        // trazendo uma lista de alunos
        String jpqlList = "SELECT * FROM aluno WHERE estado_id = :estado";
        List<Aluno> alunosList = entityManager.createNativeQuery(jpqlList, Aluno.class)
                .setParameter("estado", entityManager.find(Estado.class, 5)).getResultList();

        System.out.println("Consulta alunoSQL: " + alunoJPQL);
        alunosList.forEach(Aluno -> System.out.println("Consulta alunosSQL: " + Aluno));

        entityManager.close();
        entityManagerFactory.close();
    }
}
