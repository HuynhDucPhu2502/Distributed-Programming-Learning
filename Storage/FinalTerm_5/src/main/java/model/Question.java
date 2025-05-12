package model;

import jakarta.persistence.*;
import lombok.*;
import model.enums.Level;
import model.enums.Type;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Admin 5/10/2025
 **/
@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Question implements Serializable {

    @Id
    @Column(name = "question_id")
    @EqualsAndHashCode.Include
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_level")
    private Level level;

    @Column(name = "question_text")
    private String questionText;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private Category category;

    @OneToMany(mappedBy = "question")
    @ToString.Exclude
    private Set<Answer> answers = new HashSet<>();

    @ManyToMany(mappedBy = "questions")
    @ToString.Exclude
    private Set<Quiz> quizzes = new HashSet<>();

}
