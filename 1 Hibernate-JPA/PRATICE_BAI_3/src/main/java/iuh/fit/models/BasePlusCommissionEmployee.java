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
@Table(name = "base_plus_comission_employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePlusCommissionEmployee extends CommissionEmployee {
    @Column(name = "base_salary")
    private double baseSalary;
}
