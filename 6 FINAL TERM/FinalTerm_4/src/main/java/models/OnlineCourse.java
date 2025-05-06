package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

/**
 *  Admin 5/6/2025
 *  
**/
@Entity
public class OnlineCourse extends Course {

    @Column(name = "URL")
    private String url;

}
