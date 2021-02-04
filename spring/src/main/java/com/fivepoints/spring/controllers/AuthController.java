//package com.fivepoints.spring.controllers;
//
//import com.fivepoints.spring.payload.responses.MessageResponse;
//import com.fivepoints.spring.services.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins="*")
//@RestController
//@RequestMapping(value = "/auth")
//public class AuthController {
//
//    @Autowired
//    AuthService authService;
//
//    @RequestMapping(path = "/login", method = RequestMethod.POST)
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
//        String message = authService.login(loginRequest);
//        return ResponseEntity.ok().body(new MessageResponse(message));
//    }
//
//    @RequestMapping(path = "/register", method = RequestMethod.POST)
//    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signupRequest){
//        return authService.register(signupRequest);
//    }
//
//}
