package com.edifyine.competition.dao;

import java.util.List;

import com.edifyine.competition.pojo.QuestionAnswer;

public interface QuestionAnswerDao {

	List<QuestionAnswer> getTopicQuestions(String topicCode);

}
