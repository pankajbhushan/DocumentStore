package com.bitnbytes.documentstore.filestores.types;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bitnbytes.documentstore.document.Image;
import com.bitnbytes.documentstore.filestores.service.ImageFileStoreService;

@Component
public class ImageFileStore implements FileStore {
	
	private ImageFileStoreService imageFileStoreService;
	
	@Autowired
	private ImageFileStore(ImageFileStoreService imageFileStoreService) {
		this.imageFileStoreService = imageFileStoreService;
	}
	
	public List<Image> getImages() {	
		return imageFileStoreService.getImages();
	}
	
	@Override
	public String addFile(MultipartFile file) {
		return imageFileStoreService.addFile(file);
	}

	@Override
	public void deleteFile(String id) {
		imageFileStoreService.deleteFile(id);
	}

	@Override
	public String updateFile(String id, MultipartFile file) {
		return imageFileStoreService.updateFile(id,file);
	}

	

}
