package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 2/11/2025
 **/
@Entity
@Table(name = "Course")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private int id;

    @JoinColumn(name = "Credits")
    private int credits;

    @JoinColumn(name = "Title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "CourseIntructor",
            joinColumns = @JoinColumn(name = "CourseID"),
            inverseJoinColumns = @JoinColumn(name = "PersonID")
    )
    private Set<Instructor> instructors = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<StudentGrade> studentGrades = new HashSet<>();
}
