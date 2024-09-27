package com.djf.generalserver.controller;


import com.djf.generalserver.model.Post;
import com.djf.generalserver.model.PostRecord;
import com.djf.generalserver.service.RepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/getPost")
    public ResponseEntity<Post> getPost(@RequestParam String id) {
        Optional<Post> ret = repositoryService.getPost(Integer.parseInt(id));
        return ret.map(post -> new ResponseEntity<>(post, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
