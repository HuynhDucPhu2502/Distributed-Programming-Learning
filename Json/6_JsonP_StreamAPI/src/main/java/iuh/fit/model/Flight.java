package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Admin 4/14/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight {
    private String flightNumber;
    private String airline;

    private FlightLocation departure;
    private FlightLocation arrival;

    private List<Passenger> passengers;
}
