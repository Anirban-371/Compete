package com.edifyine.competition.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
class UserScoreMap {
	
	@Id
	long id;
	long userId;
	long easyQuestionCount;
	long easyScore;
	long mediumQuestionCount;
	long mediumScore;
	long hardQuestionCount;
	long hardScore;
}
