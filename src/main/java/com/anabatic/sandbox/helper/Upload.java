package com.anabatic.sandbox.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
	
	public static String fileUpload(String name,MultipartFile multiFile){
		try {
            byte[] bytes = multiFile.getBytes();

            // Creating the directory to store file
            String rootPath = System.getProperty("catalina.home");
            File dir = new File(rootPath + File.separator + "upload");
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath()
                    + File.separator + name);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

        
            return dir.getAbsolutePath()
                    + File.separator + name;
        } catch (Exception e) {
            return null;
        }
		
	}
}
