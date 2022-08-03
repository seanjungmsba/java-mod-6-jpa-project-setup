package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "ID_CARD")
public class IdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean isActive;

    // The `mappedBy` property tells JPA that the `student` property in the class
    // has a one-to-one relationship with the `card` property in the `Student` class
    @OneToOne(mappedBy = "card")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", isActive=" + isActive +
                '}';
    }
}