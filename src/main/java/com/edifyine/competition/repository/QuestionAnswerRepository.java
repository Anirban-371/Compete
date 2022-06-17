package com.edifyine.competition.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edifyine.competition.pojo.QuestionAnswer;
import com.edifyine.competition.pojo.Topic;

public interface QuestionAnswerRepository extends MongoRepository<Topic, Long> {
	void findByTopicCode(String topicCode);

}
