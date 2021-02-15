package com.bitnbytes.documentstore.filestores.types;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bitnbytes.documentstore.filestores.service.SimpleSizeBasedFileStoreService;

@Component
public class SimpleSizeBasedFileStore implements FileStore {

	private SimpleSizeBasedFileStoreService simpleSizeBasedFileStoreService;

	public SimpleSizeBasedFileStore(SimpleSizeBasedFileStoreService simpleSizeBasedFileStoreService) {
		super();
		this.simpleSizeBasedFileStoreService = simpleSizeBasedFileStoreService;
	}
	
	@Override
	public String addFile(MultipartFile file) {
		return simpleSizeBasedFileStoreService.addFile(file);
	}

	@Override
	public void deleteFile(String id) {
		simpleSizeBasedFileStoreService.deleteFile(id);
	}

	@Override
	public String updateFile(String id, MultipartFile file) {
		return simpleSizeBasedFileStoreService.updateFile(id,file);
	}

}
