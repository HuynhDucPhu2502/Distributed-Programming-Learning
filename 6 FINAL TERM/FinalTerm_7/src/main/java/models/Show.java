package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Admin 5/14/2025
 **/
@Entity
@Table(name = "shows")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Show implements Serializable {

    @Id
    @Column(name = "show_id")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "show_date_time")
    private LocalDateTime showDateTime;

    @Column(name = "hall_name")
    private String hallName;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @ToString.Exclude
    private Movie movie;

    @OneToMany(mappedBy = "show")
    @ToString.Exclude
    private Set<Ticket> tickets;

}
