package com.bitnbytes.documentstore.filestores.types;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bitnbytes.documentstore.document.Video;
import com.bitnbytes.documentstore.filestores.service.VideoFileStoreService;

@Component
public class VideoFileStore implements FileStore {
	
	private VideoFileStoreService videoFileStoreService;
	
	public VideoFileStore(VideoFileStoreService videoFileStoreService) {
		this.videoFileStoreService = videoFileStoreService;
	}
	
	@Override
	public String addFile(MultipartFile file) {
		return videoFileStoreService.addFile(file);
	}

	@Override
	public void deleteFile(String id) {
		videoFileStoreService.deleteFile(id);
	}

	@Override
	public String updateFile(String id, MultipartFile file) {
		return videoFileStoreService.updateFile(id, file);
	}
	
	public List<Video> getVideos(){
		return videoFileStoreService.getVideos();
	}

}
