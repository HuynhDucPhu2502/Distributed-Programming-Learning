package iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 2/9/2025
 **/
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterPrimaryKey {
    @Column(name = "chapter_num")
    private String chapterNum;

    @Column(name = "book_isbn")
    private String bookISBN;
}
