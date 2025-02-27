package iuh.fit.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {
    @EqualsAndHashCode.Include
    @SerializedName("course_id")
    private String id;

    private String name;
    private int hours;
    @ToString.Exclude
    private Department department;

}
