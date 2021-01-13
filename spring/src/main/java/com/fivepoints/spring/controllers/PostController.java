package com.fivepoints.spring.controllers;


import com.fivepoints.spring.models.User;
import com.fivepoints.spring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
//    private final PostService postService;
//
//    @Autowired
//    public PostController(PostService postService)
//    {
//        this.postService = postService;
//    }
//
//    @GetMapping("/users")
//    List<Post> all() {
//        return  this.postService.getAllUser();
//    }
//    @PostMapping("/addUser")
//    Post newUsers(@RequestBody User newUser) {
//        return  this.postService.saveNewUser(newUser);
//    }
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
