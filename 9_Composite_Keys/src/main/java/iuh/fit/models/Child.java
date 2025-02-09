package iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 2/9/2025
 **/
@Entity
@Table(name = "childs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "first_name", referencedColumnName = "firstName"),
            @JoinColumn(name = "lastName", referencedColumnName = "lastName"),
    })
    private Parent parent;


}
