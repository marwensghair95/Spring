package com.fivepoints.spring.services;

import com.fivepoints.spring.models.User;
import com.fivepoints.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public String  saveNewUser( User newUser){
                userRepository.save(newUser);
                return "User added successfully";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Integer id){
      return userRepository.findById(id);
    }

    public User update(User newUser, Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
//                    newUser.set(id);
                    return userRepository.save(newUser);
                });
    }

    public String delete(Integer id) {
         userRepository.deleteById(id);
         return "User deleted sucessfully!";
    }
}

