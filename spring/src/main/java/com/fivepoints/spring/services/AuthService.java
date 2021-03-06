//package com.fivepoints.spring.services;
//
//import com.fivepoints.spring.repositories.PostRepository;
//import org.springframework.http.ResponseEntity;
//
//import com.fivepoints.spring.payload.responses.MessageResponse;
//import com.fivepoints.spring.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//@Transactional
//
//public class AuthService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PostRepository roleRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    public String login(LoginRequest loginRequest) {
//        return "";
//    }
//
//    public ResponseEntity<?> register(SignupRequest signupRequest) {
//
//        if (userRepository.existsByEmail(signupRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: E-mail is already taken!"));
//        }
//        // Create new user's account
//        User newUser = new User();
//        newUser.setFirstName(signupRequest.getFirstName());
//        newUser.setLastName(signupRequest.getLastName());
//        newUser.setEmail(signupRequest.getEmail());
//        newUser.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
//        newUser.setAge(signupRequest.getAge());
//
//        // Add roles associations to newUser
//        Set<String> strRoles = signupRequest.getRoles();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "super-admin":
//                        Role adminRole = roleRepository.findByName(ERole.ROLE_SUPER_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    case "admin":
//                        Role modRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(modRole);
//
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
//        }
//
//        // Save newUser and return success response
//        userRepository.save(newUser);
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }
//}
