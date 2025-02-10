package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin 2/9/2025
 **/
@Entity
@Table(name = "chapters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    @EmbeddedId
    private ChapterPrimaryKey chapterPrimaryKey;

    private String title;

    @ManyToOne
    @MapsId("bookISBN")
    private Book book;




}
