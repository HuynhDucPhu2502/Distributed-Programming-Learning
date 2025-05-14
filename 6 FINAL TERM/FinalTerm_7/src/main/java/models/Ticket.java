package models;

import jakarta.persistence.*;
import lombok.*;
import models.enums.Type;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Admin 5/14/2025
 **/
@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket implements Serializable {

    @Id
    @Column(name = "ticket_number")
    @EqualsAndHashCode.Include
    private String ticketNumber;

    private String seat;

    @Enumerated(EnumType.STRING)
    private Type type;

    private double price;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @ToString.Exclude
    private Show show;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;


}
