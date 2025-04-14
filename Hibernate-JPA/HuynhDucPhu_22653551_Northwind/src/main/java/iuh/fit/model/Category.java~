package edu.iuh.fit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(name = "uc_category_name", columnNames = "category_name")
})
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name")
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}