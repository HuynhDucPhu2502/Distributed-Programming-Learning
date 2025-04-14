package iuh.fit.model;// Person.java (abstract)
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter @Setter @ToString
@NoArgsConstructor

@MappedSuperclass
public abstract class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "first_name")
    protected String firstName;
    @Column(name = "last_name")
    protected String lastName;

    @Embedded
    protected Contact contact;
}


















