package com.edifyine.competition.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edifyine.competition.pojo.QuestionAnswer;

public interface QuestionAnswerRepository extends MongoRepository<QuestionAnswer, Long> {

	void findByTopicCode(String topicCode);

}
