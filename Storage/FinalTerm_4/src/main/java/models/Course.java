package models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 5/6/2025
 **/
@Entity
@Table(name = "Course")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    protected int id;

    @Column(name = "Credits")
    protected int credits;

    @Column(name = "Title")
    protected String title;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private Department department;

    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<StudentGrade> studentGrades = new HashSet<>();

}
