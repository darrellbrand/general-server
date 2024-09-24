package com.djf.generalserver.controller;


import com.djf.generalserver.model.Post;
import com.djf.generalserver.model.PostRecord;
import com.djf.generalserver.service.RepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final RepositoryService repositoryService;


    public PostController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/findAll")

    public ResponseEntity<List<Post>> findAll() {
        return new ResponseEntity<>(repositoryService.findAll(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/save")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return new ResponseEntity<>(repositoryService.savePost(post), HttpStatus.CREATED);
    }
}
