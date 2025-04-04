package iuh.fit.model;

import java.util.List;

/**
 * Admin 4/1/2025
 **/
public class Post {
    private String id;
    private String title;
    private String content;
    private int views;
    private int likes;
    private int shares;

    private transient User user;
    private transient Approval approval;
    private transient List<Comment> comments;

}
