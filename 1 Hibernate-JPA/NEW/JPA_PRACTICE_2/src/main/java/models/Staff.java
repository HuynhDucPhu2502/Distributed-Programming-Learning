package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 4/30/2025
 **/
@Entity
@Table(name = "staffs")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Staff {

    @Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @Column(name = "staff_name", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "phones",
            joinColumns = @JoinColumn(name = "staff_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"staff_id", "number"})
    )
    @Column(name = "number")
    private Set<String> phoneNumbers;

    @Column(name = "refers")
    private String references;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    @ToString.Exclude
    private Department department;

    @ManyToMany(mappedBy = "staffs")
    @ToString.Exclude
    private Set<Project> projects = new HashSet<>();

    @OneToOne(mappedBy = "staff")
    @ToString.Exclude
    private Profile profile;

}
