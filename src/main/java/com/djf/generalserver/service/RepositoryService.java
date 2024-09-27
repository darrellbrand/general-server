package com.djf.generalserver.service;

import com.djf.generalserver.model.Post;
import com.djf.generalserver.model.PostRecord;
import com.djf.generalserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryService {

    private final PostRepository postRepository;

    @Autowired
    public RepositoryService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public Optional<Post> getPost(int id) {
        return postRepository.findById(id);
    }
    public Post savePost(Post post) {
       return  postRepository.save(post);
    }

}
