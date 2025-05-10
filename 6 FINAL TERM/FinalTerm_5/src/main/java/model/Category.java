package model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Admin 5/10/2025
 **/
@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category implements Serializable {

    @Id
    @Column(name = "category_id")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "category_name")
    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private Set<Question> questions;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private Set<Quiz> quizzes;
}
