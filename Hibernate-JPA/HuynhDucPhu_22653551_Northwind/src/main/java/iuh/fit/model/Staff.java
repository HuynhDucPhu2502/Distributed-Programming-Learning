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
@ToString(callSuper = true)
@NoArgsConstructor

@Entity
@Table(name = "staffs")
@AttributeOverride(name = "id", column = @Column(name="staff_id"))
public class Staff extends Person implements Serializable {
    private byte active;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ToString.Exclude
    @OneToMany(mappedBy = "staff")
    private List<Order> orders;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Staff manager;

    @ToString.Exclude
    @OneToMany(mappedBy = "manager")
    private List<Staff> staffs;
}