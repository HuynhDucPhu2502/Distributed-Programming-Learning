package iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@IdClass(OrderItem.OrderItemId.class)
@Table(name = "order_items")
public class OrderItem implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    @Column(name = "list_price")
    private double listPrice;
    private double discount;

    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItemId implements Serializable {
        private Order order;
        private Product product;
    }
}