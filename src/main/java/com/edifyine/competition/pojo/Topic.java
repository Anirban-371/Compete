package com.edifyine.competition.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Topic {
	@Id
	long id;
	String topicName;
	String topicDisplayName;
	String topicCode;
	String description;
	List<SubTopic> subtopicList;
}
