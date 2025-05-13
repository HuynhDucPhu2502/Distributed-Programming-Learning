package iuh.fit.models;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Admin 5/13/2025
 **/
@Entity
@Table(name = "reviews")
@IdClass(ReviewId.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Review implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    @EqualsAndHashCode.Include
    @ToString.Exclude
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "ISBN")
    @EqualsAndHashCode.Include
    @ToString.Exclude
    private Book book;

    private int rating;

    private String comment;


}
