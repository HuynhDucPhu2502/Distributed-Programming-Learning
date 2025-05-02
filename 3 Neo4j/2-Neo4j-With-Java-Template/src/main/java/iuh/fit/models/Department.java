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
public class Department {
    @JsonProperty("dept_id")
    private String departmentId;

    private String name;

    private String dean;

    private String building;

    private String room;
}
