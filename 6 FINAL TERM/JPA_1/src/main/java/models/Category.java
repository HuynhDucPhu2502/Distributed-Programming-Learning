package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Admin 4/24/2025
 **/
@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Category {

    @Id
    @Column(name = "category_id")
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    private String description;

    // Trong JPA
    // Thực thể quản lý quan hệ (Owning Side)
    // Thực thể ánh xạ (Inverse Side)

    // Khác nhau:
    // + Thằng Owning side khi persist là nó cập nhật quan hệ
    // + Thằng Inverse side khi persist là nó không cập nhật quan hệ

    // Ví dụ cụ thể
    // > 1 Category có nhiều Quizz (1 - N)
    // > Quizz là Owning Side (vì nó giữ foreign key category_id)
    // > Category là Inverse Side (dùng mappedBy)

    // ✅ Quizz.setCategory(newCategory); => Khi persist Quizz, JPA sẽ cập nhật DB (vì Quizz là Owning Side)
    // ❌ Category.getQuizzes().add(newQuizz); => Khi persist Category, JPA KHÔNG cập nhật DB nếu không set ở Owning Side

    // Vậy sao nhận biết Owning Side và Inverse Side

    // Cái nào bên nhiều thì là Owning Side
    // 1 - N, bên N là owning Side
    // N - N, bên nào cũng được
    // 1 - 1, bên nào cũng được
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Quiz> quizzes;

}
