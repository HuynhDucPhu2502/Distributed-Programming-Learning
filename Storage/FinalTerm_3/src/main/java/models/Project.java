package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Admin 5/3/2025
 **/
@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Project implements Serializable {

    @Id
    @Column(name = "project_id", columnDefinition = "VARCHAR(50)")
    @EqualsAndHashCode.Include
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
    @ToString.Exclude
    private Set<Staff> staffs = new HashSet<>();

}
