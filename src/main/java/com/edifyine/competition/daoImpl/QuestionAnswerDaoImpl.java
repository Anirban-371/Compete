package com.edifyine.competition.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifyine.competition.dao.QuestionAnswerDao;
import com.edifyine.competition.pojo.QuestionAnswer;
import com.edifyine.competition.repository.QuestionAnswerRepository;

@Service
public class QuestionAnswerDaoImpl implements QuestionAnswerDao{
	
	@Autowired
	QuestionAnswerRepository questionAnswerRepository;
	

	@Override
	public List<QuestionAnswer> getTopicQuestions(String topicCode) {
		questionAnswerRepository.findByTopicCode(topicCode);
		return null;
	}

}
