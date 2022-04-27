package com.examly.springapp.service;

import java.io.IOException;

import com.examly.springapp.entity.DocumentModel;
import com.examly.springapp.entity.User;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository docRepo;

    @Autowired
    private UserRepo userRepo;

    public DocumentModel storeFile(MultipartFile file) throws Exception {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepo.getUserByEmail(email);

        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file name contains invalid characters
            if (fileName.contains("..")) {
                throw new Exception("Sorry Filename contains invalid path " + file);
            }
            DocumentModel dbFile = new DocumentModel(fileName, file.getContentType(), file.getBytes(), u);

            dbFile.setUser(u);

            return docRepo.save(dbFile);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!!");
        }
    }

}

