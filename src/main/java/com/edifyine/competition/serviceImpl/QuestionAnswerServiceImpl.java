package com.edifyine.competition.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifyine.competition.dao.QuestionAnswerDao;
import com.edifyine.competition.pojo.QuestionAnswer;
import com.edifyine.competition.service.QuestionAnswerService;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
	
	@Autowired
	QuestionAnswerDao questionAnswerDao;

	@Override
	public List<QuestionAnswer> getTopicQuestions(long questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionAnswer> getTopicQuestions(String topicCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionAnswer> getTopicPerLevelQuestions(String topicCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
