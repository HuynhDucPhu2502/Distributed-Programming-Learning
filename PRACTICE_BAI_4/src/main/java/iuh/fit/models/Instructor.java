package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Instructor extends Person {
    @Column(name = "HireDate")
    private LocalDateTime hireDate;

    @OneToOne(mappedBy = "instructor")
    private OfficeAssignment officeAssignment;

    @ManyToMany(mappedBy = "instructors")
    private Set<Course> courses = new HashSet<>();


}
