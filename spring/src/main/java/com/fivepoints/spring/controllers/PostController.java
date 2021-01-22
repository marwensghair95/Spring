package com.fivepoints.spring.controllers;


import com.fivepoints.spring.models.Post;
import com.fivepoints.spring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/Posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping("/getPost")
    List<Post> all() {
        return  this.postService.getAllPost();
    }
    @PostMapping("/addPost")
    Post newPosts(@RequestBody Post newPost) {
        return  this.postService.saveNewPost(newPost);
    }
//    @GetMapping("/getUser/{id}")
//    Optional<Post> getUser(@PathVariable Integer id){
//        return  this.postService.getUserById(id);
//    }
//    @PutMapping("/update/{id}")
//    Post upateUser(@RequestBody User newUser,@PathVariable Integer id){
//        return this.postService.update(newUser,id);
//    }
//    @DeleteMapping("/delete/{id}")
//    void deleteUser(@PathVariable Integer id) {
//        this.postService.delete(id);
//    }
}
