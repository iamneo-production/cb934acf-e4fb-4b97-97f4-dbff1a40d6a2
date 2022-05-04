package com.examly.springapp.modeldto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileDownloadResponse {

	private String fileName;
	private String contentType;
	private String url;



}