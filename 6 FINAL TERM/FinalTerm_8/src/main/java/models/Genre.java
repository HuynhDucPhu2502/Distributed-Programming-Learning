package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Admin 5/16/2025
 **/
@Entity
@Table(name = "genres")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Genre implements Serializable {

    @Id
    @Column(name = "genre_id")
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    private String description;

}
