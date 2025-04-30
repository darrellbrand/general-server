package com.djf.generalserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

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
