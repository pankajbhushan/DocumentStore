package com.bitnbytes.documentstore.filestores.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bitnbytes.documentstore.document.Video;
import com.bitnbytes.documentstore.exception.DocumentNotFoundException;
import com.bitnbytes.documentstore.repository.VideoRepository;

@Component
public class VideoFileStoreService {

	private VideoRepository videoRepository;
	
	public VideoFileStoreService(VideoRepository videoRepository) {
		super();
		this.videoRepository = videoRepository;
	}
	
	public List<Video> getVideos(){
		return videoRepository.findAll();
	}
	
	public String addFile(MultipartFile file) {
		Video video = new Video();
		video.setTitle(file.getName());
		video.setCreatedOn(new Date(new java.util.Date().getTime()));
		try {
			video.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		}catch ( IOException e){
			//TODO Handle exception
			e.printStackTrace();
		}
		video = videoRepository.insert(video);
		return video.getId();
	}

	public void deleteFile(String id) {
		videoRepository.deleteById(id);
	}

	public String updateFile(String id, MultipartFile file) {
		Video video = new Video();
		video.setTitle(file.getName());
		video.setModifiedOn(new Date(new java.util.Date().getTime()));
		try {
			video.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
			if(videoRepository.existsById(id)) {
				videoRepository.insert(video);
			}else {
				throw new DocumentNotFoundException("Update failed!. No document found with id: " + video.getId());
			}
		}catch ( IOException e){
			//TODO Handle exception
			e.printStackTrace();
		}	
		return video.getId();
	}	
	
}
