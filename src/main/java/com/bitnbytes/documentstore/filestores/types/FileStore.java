package com.bitnbytes.documentstore.filestores.types;

import org.springframework.web.multipart.MultipartFile;

public interface FileStore {

	String addFile(MultipartFile file);
	
	void deleteFile(String id);
	
	String updateFile(String id, MultipartFile file);

}
