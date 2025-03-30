package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * Admin 3/30/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
@Data
public class Person implements Serializable {
    private String id;
    private String name;
    private String phone;
}
