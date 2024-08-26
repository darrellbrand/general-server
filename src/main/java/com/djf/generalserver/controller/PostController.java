package com.djf.generalserver.controller;


import com.djf.generalserver.model.Post;
import com.djf.generalserver.model.PostRecord;
import com.djf.generalserver.service.RepositoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final RepositoryService repositoryService;


    public PostController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/findAll")
    public List<Post> findAll() {
        return repositoryService.findAll();
    }

    @PostMapping("/save")
    public void savePost(@RequestParam String title, @RequestParam String content) {
        repositoryService.savePost(new Post(title, content));
    }
}
