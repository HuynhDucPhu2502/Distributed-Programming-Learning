package iuh.fit.models;

import jakarta.persistence.*;

/**
 * Admin 2/11/2025
 **/
@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator")
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "FirstName")
    private String name;
}
