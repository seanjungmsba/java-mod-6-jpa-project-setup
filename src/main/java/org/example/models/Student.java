package org.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // @Entity annotation tells program that JPA has to manage this class and will be using this to communicate with the database.
@Table(name = "STUDENT_DATA") // @Table annotation is being used to set the table name in the database.
public class Student {
    @Id // @Id annotation specifies the property that will be used as the unique identifier for rows in the database.
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}