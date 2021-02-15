package com.bitnbytes.documentstore.filestores.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bitnbytes.documentstore.document.Image;
import com.bitnbytes.documentstore.exception.DocumentNotFoundException;
import com.bitnbytes.documentstore.repository.ImageRepository;

@Component
public class ImageFileStoreService {

	private ImageRepository imageRepository;
	
	@Autowired
	public ImageFileStoreService(ImageRepository imageRepo) {
		super();
		this.imageRepository = imageRepo;
	}
	
	public List<Image> getImages() {
		return imageRepository.findAll();
	}

	public String addFile(MultipartFile file){
		Image image = new Image();
		image.setTitle(file.getName());
		image.setCreatedOn(new Date(new java.util.Date().getTime()));
		try {
			image.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		} catch (IOException e) {
			//TODO Handle exception
			e.printStackTrace();
		}
		image = imageRepository.insert(image);
		return image.getId();
	}

	public void deleteFile(String id) {
		imageRepository.deleteById(id);
	}

	public String updateFile(String id, MultipartFile file) {
		Image image = new Image();
		image.setTitle(file.getName());
		image.setModifiedOn(new Date(new java.util.Date().getTime()));
		try {
			image.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
			if(imageRepository.existsById(image.getId())) {
				imageRepository.insert(image);
			}else {
				throw new DocumentNotFoundException("Update failed!. No document found with id: " + image.getId());
			}
		} catch (IOException e) {
			//TODO Handle exception
			e.printStackTrace();
		}
		return image.getId();
	}
	
}
