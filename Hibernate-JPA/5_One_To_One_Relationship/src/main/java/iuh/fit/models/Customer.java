package iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Admin 2/7/2025
 **/
@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "passport_id", unique = true)
    @MapsId
    @ToString.Exclude
    private Passport passport;

}
