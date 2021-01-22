package com.fivepoints.spring.controllers;

import com.fivepoints.spring.models.User;
import com.fivepoints.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fivepoints.spring.payload.responses.MessageResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/users")
public class UserController {

    private final UserService userService;

    @Autowired
   public UserController(UserService userService)
   {
       this.userService = userService;
   }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<MessageResponse> addUser(@RequestBody User user) {
        String message = userService.saveNewUser(user);
        return ResponseEntity.ok().body(new MessageResponse(message));
    }
    @GetMapping("/getUser/{id}")
    Optional<User> getUser(@PathVariable Integer id){
        return  this.userService.getUserById(id);
    }
    @PutMapping("/update/{id}")
   User upateUser(@RequestBody User newUser,@PathVariable Integer id){
       return this.userService.update(newUser,id);
    }
    @DeleteMapping("/delete/{id}")
    String  deleteUser(@PathVariable Integer id) {
        return this.userService.delete(id);
    }
}
