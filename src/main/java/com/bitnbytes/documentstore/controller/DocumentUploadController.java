package com.bitnbytes.documentstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitnbytes.documentstore.service.DocumentStoreService;

@RestController
@RequestMapping("/document")
public class DocumentUploadController {

	private final DocumentStoreService documentStoreService;

	@Autowired
	public DocumentUploadController(DocumentStoreService documentStoreService) {
		this.documentStoreService = documentStoreService;
	}
	
	/**
	 *
	 * @author Pankaj Bhushan
	 * This implementation handles file upload
	 *
	 **/
	@PostMapping("/upload")
	public String handleDocumentUpload(@RequestParam("file") MultipartFile file) {
		return documentStoreService.handleDocumentUpload(file);
	}
}
