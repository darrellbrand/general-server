package com.djf.generalserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    private String description;

    private String email;

    private String imageUrl;
    public Post(){}

    public Post( String title, String content, String description, String email, String image) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.email = email;
        this.imageUrl = image;
    }
}
