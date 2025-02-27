package iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 2/27/2025
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @JsonProperty("student_id")
    private String studentId;

    private String name;

    private double gpa;
}
