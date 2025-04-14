package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Admin 2/4/2025
 **/
@Entity
@Table(name = "guides")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private Double salary;

    @Column(name = "staff_id")
    private String staffId;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "guide_id")
    private Set<Student> students = new HashSet<>();

}
