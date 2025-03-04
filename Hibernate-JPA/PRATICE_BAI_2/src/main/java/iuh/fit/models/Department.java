package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 2/9/2025
 **/
@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @Column(name = "dept_id", columnDefinition = "VARCHAR(50)")
    private String id;

    private String location;

    @Column(name = "dept_name")
    private String name;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private Set<Staff> staffs = new HashSet<>();
}
