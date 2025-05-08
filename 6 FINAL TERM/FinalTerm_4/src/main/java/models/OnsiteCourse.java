package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OnsiteCourse extends Course {

    @Column(name = "Days")
    private String days;

    @Column(name = "Location")
    private String location;

    @Column(name = "Time")
    private LocalTime time;
}
