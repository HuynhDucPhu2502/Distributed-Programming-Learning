package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    @EqualsAndHashCode.Include
    protected int id;

    @Column(name = "Credits")
    protected int credits;

    @Column(name = "Title")
    protected String title;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    @ToString.Exclude
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "CourseInstructor",
            joinColumns = @JoinColumn(name = "CourseID"),
            inverseJoinColumns = @JoinColumn(name = "PersonID")
    )
    @ToString.Exclude
    private Set<Instructor> instructors = new HashSet<>();


    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Set<StudentGrade> studentGrades;



}
