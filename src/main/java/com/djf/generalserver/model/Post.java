package com.djf.generalserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.parameters.P;

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

    public Post(){}

    public Post( String title, String content, String description, String email) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.email = email;
    }
}
