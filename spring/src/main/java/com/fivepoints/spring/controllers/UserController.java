package com.fivepoints.spring.controllers;

import com.fivepoints.spring.models.User;
import com.fivepoints.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/users")
public class UserController {

    private final UserService userService;

    @Autowired
   public UserController(UserService userService)
   {
       this.userService = userService;
   }

    @GetMapping("/users")
    List<User> all() {
        return  this.userService.getAllUser();
    }
    @PostMapping("/addUser")
     User newUsers(@RequestBody User newUser) {
        return  this.userService.saveNewUser(newUser);
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
