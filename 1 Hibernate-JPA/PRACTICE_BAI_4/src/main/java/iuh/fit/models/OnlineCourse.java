package iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 2/11/2025
 **/
@Entity
@Table(name = "OnlineCourse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineCourse extends Course {
    @Column(name = "URL")
    private String url;
}
