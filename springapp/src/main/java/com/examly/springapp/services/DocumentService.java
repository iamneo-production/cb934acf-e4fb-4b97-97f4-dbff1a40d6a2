package com.examly.springapp.services;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.util.StringUtils;

import com.examly.springapp.modeldto.FileDownloadResponse;
import com.examly.springapp.repoistories.DocumentRepository;
import com.examly.springapp.model.DocumentModel;

@Service
public class DocumentService {


	@Autowired
	DocumentRepository documentRepository;


	public byte[] getFile(int loanId,HttpServletResponse request) {

		DocumentModel doc =  documentRepository.findByLoanModelLoanId(loanId);

		request.setHeader("Content-Disposition", "attachment; filename=" + doc.getFileName());
		return doc.getDocument();			
	}

	public List<DocumentModel> getAllFiles(){
		return documentRepository.findAll();
	}

	public FileDownloadResponse saveDocument(MultipartFile file, String documentType,int loanId) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		DocumentModel documentModel = new DocumentModel(fileName, documentType, file.getBytes());

		documentRepository.save(documentModel);

		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFromDB")
				.path(fileName)
				.toUriString();

		String contentType = file.getContentType();

		FileDownloadResponse response = new FileDownloadResponse(fileName, contentType, url);

		return response;
	}

}

