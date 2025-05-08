package models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "Administrator")
    private int administrator;

    @Column(name = "Budget")
    private double budget;

    @Column(name = "Name")
    private String name;

    @Column(name = "StartDate")
    private LocalDateTime startDate;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private Set<Course> courses = new HashSet<>();
}
