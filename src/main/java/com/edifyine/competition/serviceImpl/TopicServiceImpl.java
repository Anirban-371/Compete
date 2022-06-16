package com.edifyine.competition.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.edifyine.competition.dao.TopicDao;
import com.edifyine.competition.pojo.DataStorage;
import com.edifyine.competition.pojo.SubTopic;
import com.edifyine.competition.pojo.Topic;
import com.edifyine.competition.pojo.TopicResponse;
import com.edifyine.competition.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	DataStorage dataStorage;
	
	@Autowired
	TopicDao topicDao;
	
	//@Autowired
	//private Map<Topic, List<?>> map;
	
	@Override
	public void saveTopic(Topic topic) {
		topic.setId(new Date().getTime());
		topicDao.saveTopic(topic);
		//map.put(topic, new ArrayList<String>());
	}

	@Override
	public List<TopicResponse> getAllTopics() {
		List<Topic> topicList = topicDao.getAllTopics();
		topicList.stream().forEach(topic->{
			TopicResponse topicResponse = new TopicResponse();
			topicResponse.setTopicCode(topic.getTopicCode());
			topicResponse.setTopicName(topic.getTopicName());			
		}) ;
		return null;
	}

	@Override
	public Topic getTopic(String id) {
		Topic topic = topicDao.getTopic(id);
		//return map.entrySet().stream().filter(val -> val.getKey().getTopicCode().equals(id)).map(val -> val.getKey()).findFirst().get();
		return topic;
	}

	@Override
	public List<SubTopic> getTopicSubTopic(String topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSubTopicByTopic(String topicId, List<SubTopic> subTopicList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSubTopic(String subTopicId, SubTopic subTopic) {
		// TODO Auto-generated method stub
		
	}
	
	

}
