package com.edifyine.competition.service;

import java.util.List;

import com.edifyine.competition.pojo.QuestionAnswer;

public interface QuestionAnswerService {

	List<QuestionAnswer> getTopicQuestions(long questionId);

	List<QuestionAnswer> getTopicQuestions(String topicCode);

	List<QuestionAnswer> getTopicPerLevelQuestions(String topicCode);

}
