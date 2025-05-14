package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Admin 5/14/2025
 **/
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    private String phone;

    private String address;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private Set<Ticket> tickets;


}
