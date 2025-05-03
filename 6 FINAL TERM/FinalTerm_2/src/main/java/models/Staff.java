package models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 *  Admin 5/3/2025
 *  
**/
@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private long id;

    @Column(nullable = false)
    private int age;

    @Column(name = "staff_name", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;

    @ElementCollection
    @JoinTable(
            name = "phones",
            joinColumns = @JoinColumn(name = "staff_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"staff_id", "number"})
    )
    @Column(name = "number")
    private Set<String> phoneNumbers;

    @Column(name = "refers")
    private String references;

    @OneToOne(mappedBy = "staff")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToMany(mappedBy = "staffs")
    private Set<Project> projects = new HashSet<>();


}
