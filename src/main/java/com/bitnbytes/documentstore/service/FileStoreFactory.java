package com.bitnbytes.documentstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bitnbytes.documentstore.filestores.types.ImageFileStore;
import com.bitnbytes.documentstore.filestores.types.SimpleSizeBasedFileStore;
import com.bitnbytes.documentstore.filestores.types.VideoFileStore;

@Component
public class FileStoreFactory {

	private ImageFileStore imageFileStore;
	private VideoFileStore videoFileStore;
	private SimpleSizeBasedFileStore simpleSizeBasedFileStore;
	
	public ImageFileStore getImageFileStore() {
		return imageFileStore;
	}
	
	@Autowired
	public void setImageFileStore(ImageFileStore imageFileStore) {
		this.imageFileStore = imageFileStore;
	}
	
	public VideoFileStore getVideoFileStore() {
		return videoFileStore;
	}
	
	@Autowired
	public void setVideoFileStore(VideoFileStore videoFileStore) {
		this.videoFileStore = videoFileStore;
	}
	
	public SimpleSizeBasedFileStore getSimpleSizeBasedFileStore() {
		return simpleSizeBasedFileStore;
	}
	
	@Autowired
	public void setSimpleSizeBasedFileStore(SimpleSizeBasedFileStore simpleSizeBasedFileStore) {
		this.simpleSizeBasedFileStore = simpleSizeBasedFileStore;
	}
	
	
}
