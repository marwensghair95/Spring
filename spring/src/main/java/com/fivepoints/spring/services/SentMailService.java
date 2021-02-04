package com.fivepoints.spring.services;


import com.fivepoints.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class SentMailService {

    @Autowired
    private JavaMailSender javaMailSender;


   public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("hazemcommerce@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }

   public void sendEmailWithAttachment(User user) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//        helper.setTo("hazemcommerce@gmail.com");
        helper.setTo(user.getEmail());
        helper.setSubject("bonjour  "+user.getFirstName());

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Votre password est!</h1>"+user.getPassword(), true);

//        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
}
