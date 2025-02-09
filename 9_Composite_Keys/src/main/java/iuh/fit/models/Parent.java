package iuh.fit.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 2/9/2025
 **/
@Entity
@Table(name = "parent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parent {
    @EmbeddedId
    private ParentPrimaryKey parentPrimaryKey;
}
