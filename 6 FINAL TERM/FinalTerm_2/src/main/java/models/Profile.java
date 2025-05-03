package models;

import jakarta.persistence.*;

/**
 *  Admin 5/3/2025
 *  
**/
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    private long id;

    private String avatar;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name = "staff_id")
    @MapsId
    private Staff staff;



}
