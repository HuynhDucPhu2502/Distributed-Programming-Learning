package iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Admin 2/10/2025
 **/
@Entity
@Table(name = "hourly_employees")
@AllArgsConstructor
@NoArgsConstructor
public class HourlyEmployee extends Employee {
    @Column(columnDefinition = "FLOAT", nullable = false)
    private double hours;

    @Column(columnDefinition = "FLOAT", nullable = false)
    private double wage;
}
