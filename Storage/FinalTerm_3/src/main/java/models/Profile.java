package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 *  Admin 5/3/2025
 *  
**/
@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Profile implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private long id;

    private String avatar;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name = "staff_id")
    @MapsId
    @ToString.Exclude
    private Staff staff;



}
