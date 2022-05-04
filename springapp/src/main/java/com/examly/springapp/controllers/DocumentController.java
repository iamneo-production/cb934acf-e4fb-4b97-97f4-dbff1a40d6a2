package com.examly.springapp.controllers;
import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;


import com.examly.springapp.services.DocumentService;

import com.examly.springapp.modeldto.FileDownloadResponse;

@CrossOrigin
@RestController
@RequestMapping("/")
public class DocumentController {

	@Autowired
	DocumentService documentService;

	@PostMapping("/saveDocument")
	public FileDownloadResponse saveDocument(@RequestParam("documentData") MultipartFile file,@RequestParam("documentType") String documentType,
			@RequestParam(value="id" , required = true) int loanId) throws IOException{
		return documentService.saveDocument(file,documentType,loanId);
	}

	@GetMapping("/downloadFromDB")
	public void downloadFile(@RequestParam(value = "id" , required = true) int  loanId,HttpServletResponse response) throws Exception{
		response.getOutputStream().write(fileContent(loanId, response));
	}

	private byte[] fileContent(int loanId,HttpServletResponse response) {
		return documentService.getFile(loanId,response);
	}
	
}