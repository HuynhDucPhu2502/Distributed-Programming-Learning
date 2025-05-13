package iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

/**
 * Admin 5/13/2025
 **/
@Entity
@Table(name = "book_translations")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(callSuper = true)
public class BookTranslation extends Book implements Serializable {

    @Column(name = "translate_name")
    private String translateName;

    private String language;

}
