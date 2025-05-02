package iuh.fit.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Department {
    @EqualsAndHashCode.Include
    @SerializedName("dept_id")
    private String id;

    private String name;
    private String dean;
    private String building;
    private String room;

}
