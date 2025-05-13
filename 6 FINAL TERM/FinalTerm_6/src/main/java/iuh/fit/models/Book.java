package iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Admin 5/13/2025
 **/
@Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    protected String ISBN;

    protected String name;

    @Column(name = "publish_year")
    protected int publishYear;

    @Column(name = "num_of_pages")
    protected int numberOfPages;

    protected double price;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "ISBN"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"ISBN", "author"})
    )
    @Column(name = "author")
    protected Set<String> authors = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    protected Publisher publisher;

    @OneToMany(mappedBy = "book")
    @ToString.Exclude
    private Set<Review> reviews = new HashSet<>();



}
