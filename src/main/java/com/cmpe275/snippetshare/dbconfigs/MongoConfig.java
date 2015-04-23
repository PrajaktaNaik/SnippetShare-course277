package com.cmpe275.snippetshare.dbconfigs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "snippetshare";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(new MongoClientURI("mongodb://kunal:cmpe275@ds061757.mongolab.com:61757/snippetshare"));
	}
	
	public static MongoOperations getMongoOperationsObj(){
		ApplicationContext ctx = 
	             new AnnotationConfigApplicationContext(MongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		return mongoOperation;
	}
}
