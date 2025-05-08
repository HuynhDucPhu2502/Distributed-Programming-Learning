package models;

import jakarta.persistence.*;
import lombok.*;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EnrollmentID")
    @EqualsAndHashCode.Include
    private int enrollmentID;

    @Column(name = "Grade")
    private double grade;

    @ManyToOne
    @JoinColumn(name = "StudentID")
    @ToString.Exclude
    private Student student;

    @ManyToOne
    @JoinColumn(name = "CourseID")
    @ToString.Exclude
    private Course course;




}
