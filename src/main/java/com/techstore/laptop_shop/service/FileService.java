package com.techstore.laptop_shop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class FileService {
    final private ServletContext servletContext;

    public FileService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveFile(MultipartFile file, String path) throws IOException {

        byte[] bytes = file.getBytes();
        String rootPath = this.servletContext.getRealPath("/assets/img");

        File dir = new File(rootPath + File.separator + "avatar");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        return fileName;
    }
}
