package models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Admin 4/30/2025
 **/
@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Profile {
    @Id
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "staff_id")
    @ToString.Exclude
    private Staff staff;

    private String avatar;

    @Column(columnDefinition = "TEXT")
    private String description;
}
