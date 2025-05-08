package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(callSuper = true)
public class Student extends Person {

    @Column(name = "EnrollmentDate")
    private LocalDateTime enrollmentDate;

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private Set<StudentGrade> studentGrades;

}
