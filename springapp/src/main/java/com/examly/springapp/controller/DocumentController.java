package com.examly.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.examly.springapp.entity.DocumentModel;
import com.examly.springapp.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    List<String> filePath = new ArrayList<>();

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        DocumentModel dbFile = documentService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getFileName())
                .toUriString();
        filePath.add(fileDownloadUri);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("File Uploaded Successfully. You can download the file from " + fileDownloadUri);
    }

}

