package models;

import jakarta.persistence.*;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID")
    protected int id;

    @Column(name = "FirstName")
    protected String firstName;

    @Column(name = "LastName")
    protected String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
