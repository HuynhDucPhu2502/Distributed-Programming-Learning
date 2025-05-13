package iuh.fit.models;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Admin 5/13/2025
 **/
@NoArgsConstructor
@EqualsAndHashCode
public class ReviewId implements Serializable {
    private String book;
    private int person;
}
