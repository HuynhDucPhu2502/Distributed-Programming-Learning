package iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Admin 2/4/2025
 **/
@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "enrollment_id")
    @EqualsAndHashCode.Include
    private String enrollmentId;

    private String name;

}
