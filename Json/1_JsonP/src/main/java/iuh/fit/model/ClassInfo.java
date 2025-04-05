package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Admin 4/4/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassInfo {
    private String name;
    private String teacher;
    private int room;
    private String startTime;
    private String endTime;

    private List<Student> studentList;
}
