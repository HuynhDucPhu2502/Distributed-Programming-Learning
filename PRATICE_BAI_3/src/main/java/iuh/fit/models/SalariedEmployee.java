package iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 2/10/2025
 **/
@Entity
@Table(name = "salaried_employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalariedEmployee extends Employee {
    @Column(name = "weekly_salary")
    private double weeklySalary;
}
