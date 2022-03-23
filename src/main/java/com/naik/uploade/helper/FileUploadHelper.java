package com.naik.uploade.helper;



import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "F:\\Users\\bharg\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\uploadefile\\src\\main\\resources\\static\\images";
    
    public boolean upload( MultipartFile multipartFile){
         boolean f = false;
         
         try {

            // Old Method
            // -------------
            
            // // reading data
            // InputStream is = multipartFile.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // // Writing data
            // FileOutputStream fo = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            // fo.write(data);
            
            // fo.flush();
            // fo.close();
          Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

           f = true;            

         } catch (Exception e) {
             e.printStackTrace();
         }



         return f;
    }
}
