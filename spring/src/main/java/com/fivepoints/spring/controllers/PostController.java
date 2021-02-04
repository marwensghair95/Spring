package com.fivepoints.spring.controllers;


import com.fivepoints.spring.models.Post;

import com.fivepoints.spring.payload.responses.MessageResponse;
import com.fivepoints.spring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/Posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping("/allPost")
    List<Post> all() {
        return  this.postService.getAllPost();
    }


    @PostMapping("/addPost")
    public ResponseEntity<MessageResponse> newPosts(@RequestBody Post newPost) {
        String message = postService.saveNewPost(newPost);
        return ResponseEntity.ok().body(new MessageResponse(message));
    }



    @GetMapping("/getByTitre/{titre}")
    List<Post> getByTitre(@PathVariable String titre){
        return  this.postService.getByTitre(titre);
    }
    @GetMapping("/getByTitreAndDescription/{titre}/{description}")
    List<Post> getByTitreAndDescription(@PathVariable String titre,@PathVariable String description){
        return  this.postService.getByTitreAndDescription(titre,description);
    }

    @GetMapping("/getPost/{id}")
    Optional<Post> getPost(@PathVariable Integer id){
        return  this.postService.getPostById(id);
    }

    @PutMapping("/update/{id}")
    Post upatePost(@RequestBody Post newPost,@PathVariable Integer id){
        return this.postService.update(newPost,id);
    }

    @DeleteMapping("/delete/{id}")
    void deletePost(@PathVariable Integer id) {
        this.postService.delete(id);
    }
}
