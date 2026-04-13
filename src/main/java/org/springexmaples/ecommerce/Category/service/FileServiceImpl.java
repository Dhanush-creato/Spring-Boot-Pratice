package org.springexmaples.ecommerce.Category.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements  FileService{

    @Override
    public String uploadImage(String path, MultipartFile image) throws IOException {

        String originalFileName = image.getOriginalFilename();

        String randomFile = UUID.randomUUID().toString();
        String completeFileName = randomFile.concat(originalFileName.substring(originalFileName.lastIndexOf(".")));
        String pathFile = path + File.separator + completeFileName;

        File folder = new File(path);  // it's only represent the path // t simply creates a File object (reference) pointing to the given path
        if(!folder.exists()){  // it will carete folder and hadel at only once
            folder.mkdirs(); // it will crate folder
        }

        Files.copy(image.getInputStream(), Paths.get(pathFile));  // to push the file into folder

        return completeFileName; // only for return file name in json

    }
}
