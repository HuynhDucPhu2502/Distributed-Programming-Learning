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
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String isbn;

    @Column(name = "book_name")
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "publisher_code")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private Set<Chapter> chapters = new HashSet<>();

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
        chapter.setBook(this);
    }

    public void removeChapter(Chapter chapter) {
        this.chapters.remove(chapter);
        chapter.setBook(null);
    }
}
