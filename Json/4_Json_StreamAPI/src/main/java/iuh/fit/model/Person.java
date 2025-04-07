package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Admin 4/7/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private Address address;

    private List<Phonenumber> phoneNumbers;
}
