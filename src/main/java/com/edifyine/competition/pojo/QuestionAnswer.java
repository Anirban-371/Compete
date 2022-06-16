package com.edifyine.competition.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class QuestionAnswer {
	@Id
	long id;
	long questionId;
	long answerId;
	String question;
	String answer;
	MultipleChoice multipleChoices;
	String description;
	String subTopicCode;
	Level level;
}
