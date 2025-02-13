package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Admin 2/11/2025
 **/
@Entity
@Table(name = "OfficeAssignment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeAssignment {

    @Id
    private Integer id;

    @Column(name = "Location")
    private String location;

    @Column(name = "TimeStamp")
    private LocalDateTime timeStamp;

    @OneToOne
    @JoinColumn(name = "InstructorID")
    @MapsId
    private Instructor instructor;
}
