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
@Table(name = "customers",indexes = {
        @Index(name = "idx_customer_first_name", columnList = "first_name"),
        @Index(name = "idx_customer_email", columnList = "email"),
        @Index(name = "idx_customer_phone", columnList = "phone")
})
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "customer_id"))
})
public class Customer extends Person implements Serializable {
    @Embedded
    private Contact contact;

    @Embedded
    private Address address;

    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}