package model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Admin 5/10/2025
 **/
@Entity
@Table(name = "quizzes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Quiz implements Serializable {

    @Id
    @Column(name = "quiz_id")
    @EqualsAndHashCode.Include
    private String id;

    private String title;

    private int score;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "quizzes_questions",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    @ToString.Exclude
    private Set<Question> questions;

}
