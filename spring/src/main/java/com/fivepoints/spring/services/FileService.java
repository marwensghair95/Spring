package com.fivepoints.spring.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fivepoints.spring.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY ;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public String saveNewFile(MultipartFile file)  throws IOException  {
        String FiletStr = String.valueOf( System.currentTimeMillis() );
        String fileName = FILE_DIRECTORY +FiletStr+"."+FilenameUtils.getExtension(file.getOriginalFilename());
        //  Upload the file
        File newFile = new File(fileName);
        newFile.createNewFile();
        FileOutputStream fos =new FileOutputStream(newFile);
        fos.write(file.getBytes());
        fos.close();
        // Save File name in database
        com.fivepoints.spring.models.File fileToSaveInDatabase = new com.fivepoints.spring.models.File();
        fileToSaveInDatabase.setFileName(fileName);
        this.fileRepository.save(fileToSaveInDatabase);
        // return statement
        return "The File Uploaded Successfully";
    }

    private  final static String getDateTime()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT")); // mention your timezone
        return df.format(new Date());
    }
}
