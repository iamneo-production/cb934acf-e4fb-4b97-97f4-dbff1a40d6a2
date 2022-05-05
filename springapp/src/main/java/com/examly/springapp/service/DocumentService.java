package com.examly.springapp.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.examly.springapp.entity.DocumentModel;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.LoanRepository;
import com.examly.springapp.entity.LoanApplicationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository docRepo;

    @Autowired
    private LoanRepository loanRepo;

    // Download File code
    public byte[] getFile(int loanId, HttpServletResponse request) {

        DocumentModel doc = docRepo.getLoanByLoanId(loanId);
        System.out.println("Doc contains: ");
        System.out.println(doc);

        request.setHeader("Content-Disposition", "attachment; filename=" + doc.getFileName());
        return doc.getData();
    }

    //Upload file code
    public DocumentModel storeFile(MultipartFile file, int loanId) throws Exception {

        LoanApplicationModel l = loanRepo.getLoanByLoanId(loanId);

        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file name contains invalid characters
            if (fileName.contains("..")) {
                throw new Exception("Sorry Filename contains invalid path " + file);
            }
            DocumentModel dbFile = new DocumentModel(fileName, file.getContentType(), file.getBytes(), l);

            dbFile.setLoan(l);

            return docRepo.save(dbFile);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!!");
        }
    }

}

