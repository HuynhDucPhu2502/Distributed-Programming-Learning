package model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Admin 5/10/2025
 **/
@Entity
@Table(name = "answers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Answer implements Serializable {

    @Id
    @Column(name = "answer_id")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @ToString.Exclude
    private Question question;

}
