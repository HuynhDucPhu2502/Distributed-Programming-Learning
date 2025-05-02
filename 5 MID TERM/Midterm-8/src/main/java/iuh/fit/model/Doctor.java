package iuh.fit.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Admin 3/30/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Builder
@ToString(callSuper = true)
public class Doctor extends Person implements Serializable {
    private String speciality;

    private transient Department department;
    private List<Treatment> treatments;

    public Doctor(String id, String name, String phone, String speciality) {
        super(id, name, phone);
        this.speciality = speciality;
    }
}
