package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * Admin 3/31/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@ToString(callSuper = true)
public class Trainer extends Person implements Serializable {
    private String specialty;

    public Trainer(String id, String name, String phone, String specialty) {
        super(id, name, phone);
        this.specialty = specialty;
    }
}
