package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 2/9/2025
 **/
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @EmbeddedId
    private UserId userId;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @MapsId("departmentId")
    private Department department;


}
