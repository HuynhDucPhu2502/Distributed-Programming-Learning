package iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Admin 3/2/2025
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @JsonProperty("student_id")
    private String id;

    private String name;

    @JsonProperty("date_of_birth")
    private LocalDateTime dob;
}
