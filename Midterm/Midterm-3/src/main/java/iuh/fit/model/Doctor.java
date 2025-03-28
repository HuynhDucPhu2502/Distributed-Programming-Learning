package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 3/28/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Doctor {
    private String doctorID;
    private String departmentID;
    private String name;
    private String phone;
    private String speciality;
}


//"speciality": "Dermatology Services",
//        "doctor_id": "DR.001",
//        "phone": "0987.654.321",
//        "name": "John Smith",
//        "dept_id": "DEP001"