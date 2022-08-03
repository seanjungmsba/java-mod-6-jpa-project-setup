package org.example;

import org.example.models.IdCard;
import org.example.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaRead {

    public static void main(String[] args) {

        // create EntityManager: we need an EntityManager for connecting to the database as before.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // get records
        Student student1 = entityManager.find(Student.class, 1); // The find method can be used to query the data from the database.
        // The first argument to find is the `class reference of the entity` we are fetching and the second argument is the `unique identifier`.
//        System.out.println(student1);

        IdCard card1 = student1.getCard();
        System.out.println(card1);

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();

    }
}