package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 2/9/2025
 **/
@Entity
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @Column(name = "project_id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(nullable = false, columnDefinition = "FLOAT")
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
