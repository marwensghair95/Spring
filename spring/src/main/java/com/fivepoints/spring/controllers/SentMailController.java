package com.fivepoints.spring.controllers;

import com.fivepoints.spring.models.User;
import com.fivepoints.spring.payload.responses.MessageResponse;
import com.fivepoints.spring.services.SentMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class SentMailController {

    private final SentMailService sentMailService;

    @Autowired
    public SentMailController(SentMailService sentMailService)
    {
        this.sentMailService = sentMailService;
    }


    @PostMapping("/addMail")
    public ResponseEntity<MessageResponse> addUser(@RequestBody User user) {
        System.out.println("Sending Email...");
        try {

//          sentMailService.sendEmail();
          sentMailService.sendEmailWithAttachment(user);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String message ="Done" ;
        return ResponseEntity.ok().body(new MessageResponse(message));
    }


}
