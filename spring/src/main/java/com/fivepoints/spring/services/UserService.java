package com.fivepoints.spring.services;

import com.fivepoints.spring.models.User;
import com.fivepoints.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<User>  getAllUser(){
        return userRepository.findAll();
    }
    public User saveNewUser( User newUser){
        return userRepository.save(newUser);
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

