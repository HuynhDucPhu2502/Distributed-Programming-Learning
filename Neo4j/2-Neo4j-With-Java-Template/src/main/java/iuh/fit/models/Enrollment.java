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
public class Enrollment {
    @JsonProperty("student_id")
    private String studentId;

    @JsonProperty("course_id")
    private String courseId;

}
