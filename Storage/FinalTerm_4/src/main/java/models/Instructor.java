package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Admin 5/6/2025
 **/
@Entity
public class Instructor extends Person  {

    @Column(name = "HireDate")
    private LocalDateTime hireDate;

    @OneToOne(mappedBy = "instructor")
    private OfficeAssignment officeAssignment;

    @ManyToMany
    @JoinTable(
            name = "CourseInstructor",
            joinColumns = @JoinColumn(name = "PersonID"),
            inverseJoinColumns = @JoinColumn(name = "CourseID")
    )
    private Set<Course> courses = new HashSet<>();

}
