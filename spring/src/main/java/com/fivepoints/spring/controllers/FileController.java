package com.fivepoints.spring.controllers;

import java.io.IOException;

import com.fivepoints.spring.payload.responses.MessageResponse;
import com.fivepoints.spring.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    private FileService fileService;

    @Autowired
    public FileController(FileService fileService)
    {
        this.fileService = fileService;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile file) throws IOException {
       String response =this.fileService.saveNewFile(file);
        return new ResponseEntity<Object>(new MessageResponse(response), HttpStatus.OK);
    }
}
