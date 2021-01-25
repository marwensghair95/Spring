package com.fivepoints.spring.services;


import com.fivepoints.spring.models.Post;
import com.fivepoints.spring.models.User;
import com.fivepoints.spring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public String saveNewPost(Post newPost){
        postRepository.save(newPost);
        return "Post added successfully";
    }
    public Optional<Post> getPostById(Integer id){
        return postRepository.findById(id);
    }

    public String delete(Integer id) {
        postRepository.deleteById(id);
        return "Post deleted sucessfully!";
    }
    public Post update(Post newPost, Integer id) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitre(newPost.getTitre());
                    post.setDescription(newPost.getDescription());
                    return postRepository.save(post);
                })
                .orElseGet(() -> {
//                    newUser.set(id);
                    return postRepository.save(newPost);
                });
    }
}
