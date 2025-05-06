package models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity

public class OfficeAssignment {

    @Id
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
    private Instructor instructor;



}
