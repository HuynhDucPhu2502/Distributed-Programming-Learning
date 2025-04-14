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
public class Baggage {
    private boolean checkedIn;
    private double weightKg;
}
