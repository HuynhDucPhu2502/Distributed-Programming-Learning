package iuh.fit.models;

import jakarta.persistence.*;

/**
 * Admin 2/10/2025
 **/
@Entity
@Table(name = "comission_employees")
@Inheritance(strategy = InheritanceType.JOINED)
public class CommissionEmployee extends Employee {
    @Column(name = "comission_rate")
    private double comissionRate;

    @Column(name = "gross_sales")
    private double grossSales;
}
