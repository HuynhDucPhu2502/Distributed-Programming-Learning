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
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Department implements Serializable {

    @Id
    @Column(name = "dept_id", columnDefinition = "VARCHAR(50)")
    @EqualsAndHashCode.Include
    private String id;

    private String location;

    @Column(name = "dept_name")
    private String name;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private Set<Staff> staffs = new HashSet<>();




}
