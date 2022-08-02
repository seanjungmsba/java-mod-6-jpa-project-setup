package org.example;

import org.example.enums.StudentGroup;
import org.example.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUpdate {
    public static void main(String[] args) {

        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // get record
        Student student1 = entityManager.find(Student.class, 1);

        // modify the studentGroup field of the instance to DAISY.
        student1.setStudentGroup(StudentGroup.DAISY);

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        // create and use transaction to save updated value
        transaction.begin();
        entityManager.persist(student1);
        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}