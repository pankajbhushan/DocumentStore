package com.bitnbytes.documentstore.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.bitnbytes.documentstore.filestores.types.FileStore;

/**
 *
 *@author Pankaj Bhushan
 *
 *SimpleFileStoreFactory provides interface for generating different FileStore objects
 *based on the file type. If the factory is unable to identify the file type,
 *it fallback to SimpleSizeBasedFileStore that stores files as regular document if it's less than 16MB
 *else it stores the file in MongoDB GridFS
 *
 *@since 1.0
 * 
 **/
@Component
public class SimpleFileStoreFactory extends FileStoreFactory{

	private FileStore fileStore;
	
	public FileStore getFileStore(String fileType) {
		Assert.hasText(fileType, "File Type must be specified");
		if(getImageTypes().contains(fileType)){
			this.fileStore = getImageFileStore(); 
		} else if(getVideoTypes().contains(fileType)) {
			this.fileStore = getVideoFileStore();
		} else {
			this.fileStore = getSimpleSizeBasedFileStore();
		}
		return this.fileStore;
	}

	private List<String> getImageTypes() {
		return Arrays.asList("image/jpg","image/jpeg","image/png");
	}

	private List<String> getVideoTypes() {
		return Arrays.asList("mpeg","mp4","mkv", "avi");
	}
	
	private List<String> getDocumentTypes(){
		return Arrays.asList("application/doc","application/xls","application/xlsx","application/txt","application/csv","application/pdf","application/ppt");
	}
	
}
