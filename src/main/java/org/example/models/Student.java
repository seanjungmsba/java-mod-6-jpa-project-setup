package org.example.models;

import org.example.enums.StudentGroup;

import javax.persistence.*;
import java.util.Date;

@Entity // @Entity annotation tells program that JPA has to manage this class and will be using this to communicate with the database.
@Table(name = "STUDENT_DATA") // @Table annotation is being used to set the table name in the database.
public class Student {
    @Id // @Id annotation specifies the property that will be used as the unique identifier for rows in the database.
    @GeneratedValue // @Generated annotation makes the database generate unique IDs automatically. It’s added to the field that along with the @Id annotation.
    private int id;
    @Basic // @Basic annotation uses the property name as the column name and infers the database data type from the Java data type.
    @Column // @Column annotation is used for customizing how properties will be mapped to a database column.
    private String name;

    @Temporal(TemporalType.DATE) // @Temporal annotation is used to define how the information will be stored in the database
    private Date dob; // For production apps, you would use the LocalDate class instead of the Date class.

    @Enumerated(EnumType.STRING) // We can store the value of the enum instead using the @Enumerated annotation.
    //  if you want to ensure that your database values are not invalidated in the future due to order changes in the enum,
    //  use the @Enumerated annotation with the EnumType.STRING value.
    private StudentGroup studentGroup;

    @Transient // @Transient annotation is used when we don’t want a property to be used for database creation.
    private String debugMessage;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

}