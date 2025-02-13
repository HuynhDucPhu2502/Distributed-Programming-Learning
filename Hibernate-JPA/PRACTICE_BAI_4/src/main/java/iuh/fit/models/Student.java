package iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@DiscriminatorValue("Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    @Column(name = "EnrollmentDate")
    private LocalDateTime enrollmentDate;

    @OneToMany(mappedBy = "student")
    private Set<StudentGrade> studentGrades = new HashSet<>();

}
