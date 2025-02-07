package iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Admin 2/7/2025
 **/
@Entity
@Table(name = "passports")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String passport;

    @OneToOne(mappedBy = "passport")
    @ToString.Exclude
    private Customer customer;
}
