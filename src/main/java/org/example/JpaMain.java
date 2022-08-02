package org.example;

import org.example.models.Student;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaMain {
    public static void main(String[] args) {

        // create a new student instance
            // we are creating a new student instance which is a regular Java object
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Jack");

        // create EntityManager
            // We need to use an EntityManagerFactory because we want a single instance of an EntityManager in our app.
            // We also have to get the EntityTransaction object from the EntityManager because we have to define our own transactions.
            // This is boilerplate code required when working with JPA but these aren’t required
            // when using frameworks which provide auto configurations such as Spring (with SpringBoot).
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        // create and use transactions
        transaction.begin();
        entityManager.persist(student1); // The persist method tells the database to create and insert a student row using the data provided.
        transaction.commit();

    }
}