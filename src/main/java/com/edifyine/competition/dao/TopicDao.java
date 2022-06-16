package com.edifyine.competition.dao;

import java.util.List;

import com.edifyine.competition.pojo.Topic;

public interface TopicDao {

	void saveTopic(Topic topic);

	Topic getTopic(String id);

	List<Topic> getAllTopics();
	
	
}
