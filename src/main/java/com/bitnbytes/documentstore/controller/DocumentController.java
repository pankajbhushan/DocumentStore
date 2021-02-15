package com.bitnbytes.documentstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitnbytes.documentstore.document.Image;
import com.bitnbytes.documentstore.document.Video;
import com.bitnbytes.documentstore.service.DocumentStoreService;

@RestController
@RequestMapping("/documents")
public class DocumentController {
	
	private DocumentStoreService documentStoreService;
	
	public DocumentController(DocumentStoreService documentStoreService) {
		this.documentStoreService = documentStoreService;
	}
	
	@GetMapping("/images")
	public List<Image> getAllImages(){
		return documentStoreService.getAllImages();
	}
	
	@GetMapping("/videos")
	public List<Video> getAllVideos(){
		return documentStoreService.getAllVideos();
	}
}
