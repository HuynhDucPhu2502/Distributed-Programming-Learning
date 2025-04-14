package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Admin 2/11/2025
 **/
@Entity
@DiscriminatorValue("Instructor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
public class Instructor extends Person {
    @Column(name = "HireDate")
    @ToString.Include
    private LocalDateTime hireDate;

    @OneToOne(mappedBy = "instructor")
    @ToString.Exclude
    private OfficeAssignment officeAssignment;

    @ManyToMany(mappedBy = "instructors")
    @ToString.Exclude
    private Set<Course> courses = new HashSet<>();


}
