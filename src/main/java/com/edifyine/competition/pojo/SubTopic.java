package com.edifyine.competition.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class SubTopic {

	@Id
	long id;
	String subTopicName;
	String subTopicDisplayName;
	String subTopicCode;
	String description;
	
}
