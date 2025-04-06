package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Admin 4/6/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Country {
    private int id;
    private int area;
    private String capital;
    private String cca2;
    private String cioc;
    private String demonym;
    private boolean landLocked;
    private String region;
    private String subregion;

    private List<String> altSpellings;
    private List<String> borders;
    private List<String> callingCode;
    private List<String> currency;
    private List<Integer> latlng;

    private Name name;
    private Map<String, Translation> translations;

}
