package models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OfficeAssignment {

    @Id
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "Location")
    private String location;

    // Java 8
    @Column(name = "Timestamp")
    private LocalDateTime timestamp;
    // legacy
    // private Timestamp timestamp;


    @OneToOne
    @JoinColumn(name = "InstructorID")
    @MapsId
    @ToString.Exclude
    private Instructor instructor;



}
