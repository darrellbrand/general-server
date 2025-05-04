package com.djf.generalserver.controller;


import com.djf.generalserver.model.Post;
import com.djf.generalserver.service.RepositoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final String url ="https://inventory-frontend-6c04aaa61769.herokuapp.com/";
    private final RepositoryService repositoryService;


    public PostController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;

    }

    @CrossOrigin(origins = url, allowCredentials = "true")
    @GetMapping("/findAll")

    public ResponseEntity<List<Post>> findAll() {
        return new ResponseEntity<>(repositoryService.findAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = url, allowCredentials = "true")
    @PostMapping("/save")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return new ResponseEntity<>(repositoryService.savePost(post), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = url, allowCredentials = "true")
    @GetMapping("/getPost")
    public ResponseEntity<Post> getPost(@RequestParam String id) {
        Optional<Post> ret = repositoryService.getPost(Integer.parseInt(id));
        return ret.map(post -> new ResponseEntity<>(post, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @CrossOrigin(origins = url, allowCredentials = "true")
    @PostMapping("/deletePost")
    public ResponseEntity<Void> deletePost(@RequestParam String id) {
        repositoryService.deletePost(Integer.parseInt(id));
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
