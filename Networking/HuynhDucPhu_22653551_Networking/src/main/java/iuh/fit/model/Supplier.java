package iuh.fit.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier implements Serializable {
    private int supplierID;
    private String companyName;
    private ContactInfo contactInfo;
    private Address address;
    private String homePage;
}