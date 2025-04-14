package iuh.fit.model;

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
@Table(name = "brands", uniqueConstraints = {
        @UniqueConstraint(name = "uc_brand_name", columnNames = "brand_name")
})

public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int id;
    @Column(name = "brand_name")
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "brand")
    private List<Product> products;
}