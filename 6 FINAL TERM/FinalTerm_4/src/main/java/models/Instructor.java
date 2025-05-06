package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
public class Instructor extends Person {

    @Column(name = "HireDate")
    private LocalDateTime hireDate;

    @OneToOne(mappedBy = "instructor")
    private OfficeAssignment officeAssignment;

    @ManyToMany(mappedBy = "instructors")
    private Set<Course> courses = new HashSet<>();

}
