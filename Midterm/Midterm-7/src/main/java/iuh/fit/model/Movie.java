package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Admin 3/30/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Movie implements Serializable {
    private String title;
    private String tagline;
    private int released;
}
