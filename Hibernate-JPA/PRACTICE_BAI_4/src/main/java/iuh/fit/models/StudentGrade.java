package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 2/11/2025
 **/
@Entity
@Table(name = "StudentGrade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EnrollmentID")
    private int enrollmentID;

    @Column(name = "Grade")
    private double grade;

    @ManyToOne
    @JoinColumn(name = "CourseID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "StudentID")
    private Student student;

}
