package iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Admin 2/9/2025
 **/
@Embeddable
public class UserId {
    @Column(name = "user_name")
    private String userName;

    @Column(name = "department_id")
    private Long departmentId;
}
