package com.fivepoints.spring.services;


import com.fivepoints.spring.models.Post;
import com.fivepoints.spring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository repository) {
        this.postRepository = repository;
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
    public Post saveNewPost(Post newPost){
        return postRepository.save(newPost);
    }

}
