package models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 5/3/2025
 **/
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "dept_id", columnDefinition = "VARCHAR(50)")
    private String id;

    private String location;

    @Column(name = "dept_name")
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Staff> staffs = new HashSet<>();




}
