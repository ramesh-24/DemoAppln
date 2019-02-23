package com.company.security.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.security.utils.MediaTypeUtils;

@Controller
public class Download1Controller {
	private static final String DIRECTORY = "E:\\ALL_MY_DOCS\\GovIDs";
	private static final String DEFAULT_FILE_NAME = "Ramesh_Nallajarla_AadharCard.pdf";
	@Autowired  //E:\ALL_MY_DOCS\GovIDs
	private ServletContext servletContext;

	// http://localhost:8080/download1?fileName=abc.zip
	// Using ResponseEntity<InputStreamResource>
	@RequestMapping("/download1")
	public ResponseEntity<InputStreamResource> downloadFile1(
			@RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {

		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
		System.out.println("fileName: " + fileName);
		System.out.println("mediaType: " + mediaType);

		File file = new File(DIRECTORY + "/" + fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		return ResponseEntity.ok()
				// Content-Disposition
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
				// Content-Type
				.contentType(mediaType)
				// Contet-Length
				.contentLength(file.length()) //
				.body(resource);
	}
}
