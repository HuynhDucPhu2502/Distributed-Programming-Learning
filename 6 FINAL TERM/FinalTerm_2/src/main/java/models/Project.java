package models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 5/3/2025
 **/
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @Column(name = "project_id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(columnDefinition = "FLOAT", nullable = false)
    private double budget;

    @Column(name = "project_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "staff_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private Set<Staff> staffs = new HashSet<>();

}
