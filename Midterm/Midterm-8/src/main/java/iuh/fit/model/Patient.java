package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Admin 3/30/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
@Data
public class Patient extends Person implements Serializable {
    private Gender gender;
    private String dateOfBirth;
    private String address;

    private transient List<Treatment> treatments;

    public Patient(String id, String name, String phone, String address) {
        super(id, name, phone);
        this.address = address;
    }
}
