package com.edifyine.competition.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifyine.competition.pojo.QuestionAnswer;
import com.edifyine.competition.service.QuestionAnswerService;

@RestController
@RequestMapping("/question/answers")
public class QuestionAnswerController {
	
	Logger logger = LoggerFactory.getLogger(QuestionAnswerController.class);
	
	@Autowired
	QuestionAnswerService questionAnswerService;
	
	@GetMapping("/{subTopicCode}")
	public ResponseEntity<List<QuestionAnswer>> getTopicQuestions(@PathParam("subTopicCode") String subTopicCode){
		return new ResponseEntity<>(questionAnswerService.getTopicQuestions(subTopicCode),HttpStatus.OK);
				
	}
	
	@GetMapping("/{subTopicCode}/{level}")
	public ResponseEntity<List<QuestionAnswer>> getTopicPerLevelQuestions(@PathParam("subTopicCode") String subTopicCode){
		return new ResponseEntity<>(questionAnswerService.getTopicPerLevelQuestions(subTopicCode),HttpStatus.OK);
				
	}
	
	@GetMapping("/{questionId}")
	public ResponseEntity<List<QuestionAnswer>> getCorrectAnswers(@QueryParam("questionId") long questionId){
		
		return new ResponseEntity<>(questionAnswerService.getTopicQuestions(questionId),HttpStatus.OK);
				
	}
	
	@PostMapping
	public ResponseEntity<Void> saveQuestionAnswers(@RequestBody List<QuestionAnswer> questionAnswerList){
		
		return new ResponseEntity<Void>(HttpStatus.OK);
				
	}
	@DeleteMapping("/{questionId}")
	public ResponseEntity<List<QuestionAnswer>> deleteQuestionAnswer(@QueryParam("questionId") long questionId){
		
		return new ResponseEntity<>(HttpStatus.OK);
				
	}
}
