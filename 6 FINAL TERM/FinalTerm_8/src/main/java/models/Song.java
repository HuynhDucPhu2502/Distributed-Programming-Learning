package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Admin 5/16/2025
 **/
@Entity
@Table(name = "songs")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Song implements Serializable {

    @Id
    @Column(name = "song_id")
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    private String runTime;

    private String lyric;

    @Column(name = "file_link")
    private String fileLink;

    @ManyToMany(mappedBy = "songs")
    @ToString.Exclude
    private Set<Album> albums;

}
