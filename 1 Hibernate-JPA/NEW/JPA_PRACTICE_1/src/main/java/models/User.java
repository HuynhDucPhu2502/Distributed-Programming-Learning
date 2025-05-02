package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Admin 4/29/2025
 **/
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @EqualsAndHashCode.Include
    private int userId;

    @Column(columnDefinition = "VARCHAR(45)", nullable = false)
    private String username;

    @Column(columnDefinition = "VARCHAR(45)", nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(45)", nullable = false)
    private String email;

    @ManyToMany(mappedBy = "users")
    @ToString.Exclude
    private Set<Group> groups = new LinkedHashSet<>();
}
