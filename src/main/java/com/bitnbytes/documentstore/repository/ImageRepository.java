package com.bitnbytes.documentstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bitnbytes.documentstore.document.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

}
