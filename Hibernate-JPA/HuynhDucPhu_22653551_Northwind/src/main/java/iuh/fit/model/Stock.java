package iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@IdClass(Stock.StockId.class)
@Table(name = "stocks")
public class Stock implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StockId implements Serializable {
        private Store store;
        private Product product;
    }
}