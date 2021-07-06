package com.bitnbytes.documentstore.filestores.service;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bitnbytes.documentstore.exception.DocumentNotFoundException;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Component
public class SimpleSizeBasedFileStoreService {

	@Autowired private GridFsTemplate gridFsTemplate;
	
	public String addFile(MultipartFile file) {
		String result = null;
		DBObject metadata = new BasicDBObject();
		metadata.put("version", String.valueOf(1));
		metadata.put("user", "document-store-api");
		try {
			ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getName(), metadata);
			result = id.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deleteFile(String id) {
		gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
	}

	public String updateFile(String id, MultipartFile file) {
		// TODO GridFs does not support/recommend file updates. If this is needed try version
		// the file with each add/update and store new versions of file for each update
		String result = null;
		if(null != gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)))) {
			DBObject metadata = new BasicDBObject();
			metadata.put("version", String.valueOf(2));
			metadata.put("previousFileId", id);
			metadata.put("user", "document-store-api");
			ObjectId objectId;
			try {
				objectId = gridFsTemplate.store(file.getInputStream(), file.getName(), metadata);
				result = objectId.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			throw new DocumentNotFoundException();
		}
		return result;
	}

	
}
