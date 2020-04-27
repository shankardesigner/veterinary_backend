package com.shankardesigner.poudelveterinary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.shankardesigner.poudelveterinary.configuration.Const.UPLOAD_PATH;

@RestController
@CrossOrigin
public class FileUploadController {
    @Autowired
    private HttpServletRequest request;

//    @Value("${file.upload-dir}")
//    UPLOAD_PATH

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file, @RequestParam String folderPath) throws IOException {
        Map<String,String> errMsg = new HashMap<String, String>();
        String newPath = folderPath + "/";
        String responseMessage = "";
        if(file.isEmpty()) {
            responseMessage = "Please select the file.";
            errMsg.put("file",responseMessage);
            return new ResponseEntity<Map<String,String>>(errMsg, HttpStatus.BAD_REQUEST);
        }
        try {
            byte[] bytes = file.getBytes();
            String fileNameWithPath = newPath + file.getOriginalFilename();
            String fileWithFileName = UPLOAD_PATH + fileNameWithPath;

            File f = new File(UPLOAD_PATH + newPath);
            if(!f.exists()) {
                f.mkdir();
            }
            Path path = Paths.get(fileWithFileName);
            Files.write(path,bytes);
            return new ResponseEntity<String>(fileNameWithPath, HttpStatus.OK);
        } catch (IOException ex) {
            responseMessage = "File upload failed. " + ex;
            errMsg.put("file",responseMessage);
            return new ResponseEntity<Map<String,String>>(errMsg, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteByName")
    public ResponseEntity<?> deleteImageByName(@RequestParam String image) {
        Map<String,String> errMsg = new HashMap<String, String>();
        System.out.println(image);
        try {
            Files.deleteIfExists(Paths.get(UPLOAD_PATH + image));
            errMsg.put("image",image);
            return new ResponseEntity<Map<String,String>>(errMsg, HttpStatus.OK);
        } catch (IOException e) {
            errMsg.put("image",image+e);
            return new ResponseEntity<Map<String,String>>(errMsg, HttpStatus.BAD_REQUEST);
        }
    }
}
