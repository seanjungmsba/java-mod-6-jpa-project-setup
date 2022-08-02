package org.example;

import org.example.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaDelete {
    public static void main(String[] args) {

        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // get record
        Student student1 = entityManager.find(Student.class, 1);

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        // create and use transaction to save updated value
        transaction.begin();
        entityManager.remove(student1); // call the remove method on the entity manager and pass it the Student instance you want to remove from the database.
        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}