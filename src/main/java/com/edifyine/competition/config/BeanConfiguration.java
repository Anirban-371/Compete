package com.edifyine.competition.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.edifyine.competition.pojo.DataStorage;
import com.edifyine.competition.pojo.Topic;

@Configuration
public class BeanConfiguration {
	
	
	
	
	@Bean
	public DataStorage getDataStorage() {
		return new DataStorage();
	}
	
	@Bean 
	public Map<String, List<?>> myVal(){
		Map<String, List<?>> map = new HashMap<String, List<?>>();
      return map;      
   }
	
	@Bean
	public BlockingQueue<String> getQueue(){
		BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(1000);
		return msgQueue;
	}
	

}
