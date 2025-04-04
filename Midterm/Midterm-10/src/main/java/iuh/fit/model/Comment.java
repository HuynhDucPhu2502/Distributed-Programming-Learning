package iuh.fit.model;

import java.time.LocalDate;

/**
 * Admin 4/1/2025
 **/
public class Comment {
    private String comment;
    private LocalDate date;
    private int likes;

    private transient Post post;
    private transient User user;
}
