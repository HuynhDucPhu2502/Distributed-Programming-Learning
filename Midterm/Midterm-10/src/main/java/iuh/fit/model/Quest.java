package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Admin 4/1/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quest implements Serializable {
    private String title;
    private String id;
    private Level level;
    private int points;
    private int count;
}
