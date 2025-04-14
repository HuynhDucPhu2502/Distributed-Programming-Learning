package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * Admin 3/31/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Person implements Serializable {
    private String id;
    private String name;
    private String phone;
}
