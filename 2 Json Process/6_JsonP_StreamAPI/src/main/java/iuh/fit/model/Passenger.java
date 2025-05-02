package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 4/14/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Passenger {
    private String name;
    private int age;
    private String passport;
    private String seat;

    private Baggage baggage;
}
