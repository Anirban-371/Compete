package com.edifyine.competition.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifyine.competition.dao.TopicDao;
import com.edifyine.competition.pojo.Topic;
import com.edifyine.competition.repository.TopicRepository;

@Service
public class TopicDaoImpl implements TopicDao{
	
	@Autowired
	TopicRepository topicRepository;

	@Override
	public void saveTopic(Topic topic) {
		topicRepository.save(topic);
	}

	@Override
	public Topic getTopic(String id) {
		Topic topic = topicRepository.findByTopicCode(id);
		return topic;
	}

	@Override
	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
	}
	
	
	

}
