package iuh.fit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Admin 1/13/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private ArrayList<PhoneNumber> phoneNumbers;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                "\n, lastName='" + lastName + '\'' +
                "\n, age=" + age +
                "\n, address=" + address +
                "\n, phoneNumbers=" + phoneNumbers +
                '}';
    }
}
