package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Admin 4/14/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightLocation {
    private String city;
    private String airport;
    private LocalDateTime time;
}
