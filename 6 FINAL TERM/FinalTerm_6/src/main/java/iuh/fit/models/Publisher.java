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
@Table(name = "publishers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher implements Serializable {

    @Id
    @Column(name = "publisher_id")
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    private String address;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "publisher")
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();

}
