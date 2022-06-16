package com.edifyine.competition.service;

import java.util.List;
import java.util.Set;

import com.edifyine.competition.pojo.SubTopic;
import com.edifyine.competition.pojo.Topic;
import com.edifyine.competition.pojo.TopicResponse;

public interface TopicService {

	void saveTopic(Topic topic);

	List<TopicResponse> getAllTopics();

	Topic getTopic(String id);

	List<SubTopic> getTopicSubTopic(String topicId);

	void saveSubTopicByTopic(String topicId, List<SubTopic> subTopicList);

	void updateSubTopic(String subTopicId, SubTopic subTopic);

}
