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
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private int postalCode;
}
