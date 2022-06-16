package com.edifyine.competition.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class MultipleChoice {
	@Id
	long id;
	List<String> multipleChoices;
}
