package iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Admin 2/4/2025
 **/
@Entity
@Table(name = "people")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @Embedded
    private Address address;


}
