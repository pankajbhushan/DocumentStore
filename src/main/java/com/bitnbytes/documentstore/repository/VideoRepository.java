package com.bitnbytes.documentstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bitnbytes.documentstore.document.Video;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {

	
}
