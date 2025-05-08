package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(callSuper = true)
public class OnlineCourse extends Course {

    @Column(name = "URL")
    private String url;

}
