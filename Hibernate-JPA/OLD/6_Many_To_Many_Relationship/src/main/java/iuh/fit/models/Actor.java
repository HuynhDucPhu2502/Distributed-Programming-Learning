package iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 2/8/2025
 **/
@Entity
@Table(name = "actors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @EqualsAndHashCode.Include
    private String name;

    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.PERSIST})
    @ToString.Exclude
    private Set<Movie> movies = new HashSet<>();

    public void addMovie(Movie movie) {
        this.movies.add(movie);
        movie.getActors().add(this);
    }

    public void removeMoive(Movie movie) {
        this.movies.remove(movie);
        movie.getActors().remove(this);
    }

}
