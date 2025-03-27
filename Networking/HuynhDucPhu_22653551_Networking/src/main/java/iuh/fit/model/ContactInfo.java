package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo implements Serializable {
    private String contactName;
    private String contactTitle;
    private List<String> phone;
    private String fax;
}