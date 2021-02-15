package com.bitnbytes.documentstore.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitnbytes.documentstore.document.Image;
import com.bitnbytes.documentstore.document.Video;

@Service
public class DocumentStoreService {
	
	private SimpleFileStoreFactory simpleFileStoreFactory;

	public DocumentStoreService(SimpleFileStoreFactory simpleFileStoreFactory) {
		this.simpleFileStoreFactory = simpleFileStoreFactory;
	}

	public List<Image> getAllImages(){
		return simpleFileStoreFactory.getImageFileStore().getImages();
	}
	
	public List<Video> getAllVideos(){
		return simpleFileStoreFactory.getVideoFileStore().getVideos();
	}
	
	public String handleDocumentUpload(MultipartFile file) {
		String result = simpleFileStoreFactory.getFileStore(file.getContentType()).addFile(file);
		return result;
	}

}
