package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.io.Serializable;
import java.util.List;

/**
 * Admin 3/30/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department implements Serializable {
    private String id;
    private String name;
    private String location;

    private transient List<Doctor> doctors;
}
