package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Admin 2/9/2025
 **/
@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    private Long id;

    private String avatar;

    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "staff_id")
    @ToString.Exclude
    private Staff staff;
}
