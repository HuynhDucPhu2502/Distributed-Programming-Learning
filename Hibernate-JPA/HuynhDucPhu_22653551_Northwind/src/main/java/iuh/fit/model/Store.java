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
@Table(name = "stores")
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int id;
    @Column(name = "store_name")
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Contact contact;

    @ToString.Exclude
    @OneToMany(mappedBy = "store")
    private List<Staff> staffs;

    @ToString.Exclude
    @OneToMany(mappedBy = "store")
    private List<Stock> stocks;
}