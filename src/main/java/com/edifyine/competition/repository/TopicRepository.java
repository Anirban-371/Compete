package com.edifyine.competition.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edifyine.competition.pojo.Topic;

@Repository
public interface TopicRepository extends MongoRepository<Topic, Long>{

	Topic findByTopicCode(String id);

}
