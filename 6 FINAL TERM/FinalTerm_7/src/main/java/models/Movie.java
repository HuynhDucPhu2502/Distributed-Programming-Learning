package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Admin 5/14/2025
 **/
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie implements Serializable {

    @Id
    @Column(name = "movie_id")
    @EqualsAndHashCode.Include
    private String id;

    private String title;

    private String genre;

    @Column(name = "release_year")
    private int releaseYear;

    private String director;

    private int duration;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id")
    )
    @Column(name = "actor", nullable = false)
    private Set<String> actors;


    @OneToMany(mappedBy = "movie")
    @ToString.Exclude
    private Set<Show> shows;
}
