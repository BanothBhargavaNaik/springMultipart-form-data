package com.naik.uploade.controller;

import com.naik.uploade.helper.FileUploadHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1")
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file ){

        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getContentType());
        // System.out.println(file.getSize());
        // System.out.println(file.getName());
        
        try {

           boolean f =  fileUploadHelper.upload(file);
          if(f){
              return ResponseEntity.ok("File is Uploaded Successfully...!");
          }
        } catch (Exception e) {
            e.printStackTrace();
        }

           
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ... Try again");
    }

}
