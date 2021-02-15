package com.bitnbytes.documentstore.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.MongoClientSettings.Builder;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfigAdapter extends AbstractMongoClientConfiguration {

	@Autowired	private MappingMongoConverter mongoConverter;
	
	@Override
	protected String getDatabaseName() {
		return "documentstore";
	}

	@Override
	protected void configureClientSettings(Builder builder) {
		builder.credential(MongoCredential.createCredential("root", "documentstore", "root".toCharArray()))
								.applyToClusterSettings(settings -> {
										settings.hosts(Collections.singletonList(new ServerAddress("127.0.0.1",27017)));
								});
	}
	
	@Bean
	public GridFsTemplate gridFsTemplate() {
		return new GridFsTemplate(mongoDbFactory(), mongoConverter);
	}

}
