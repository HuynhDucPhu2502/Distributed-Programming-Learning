package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Admin 5/16/2025
 **/
@Entity
@Table(name = "artists")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Artist implements Serializable {

    @Id
    @Column(name = "artist_id")
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String url;

    @ManyToMany(mappedBy = "artists")
    @ToString.Exclude
    private Set<Album> albums;

}
