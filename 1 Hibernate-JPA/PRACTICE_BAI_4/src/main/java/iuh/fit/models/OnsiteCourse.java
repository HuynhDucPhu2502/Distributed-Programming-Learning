package iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Admin 2/11/2025
 **/
@Entity
@Table(name = "OnsiteCourse")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OnsiteCourse extends Course {
    @Column(name = "Days")
    private String days;
    @Column(name = "Location")
    private String location;
    @Column(name = "Time")
    private LocalTime time;
}
