package iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 2/9/2025
 **/
@Entity
@Table(name = "staffs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long id;

    @Column(nullable = false)
    private int age;

    @Column(name = "staff_name", nullable = false)
    private String name;

    @Column(name = "refers")
    private String references;

    @ElementCollection
    @CollectionTable(
            name = "phones",
            joinColumns = @JoinColumn(name = "staff_id")
    )
    @Column(name = "number", nullable = false)
    private Set<String> phoneNumbers = new HashSet<>();

    @OneToOne(mappedBy = "staff")
    @ToString.Exclude
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToMany(mappedBy = "staffs")
    private Set<Project> projects = new HashSet<>();

}
