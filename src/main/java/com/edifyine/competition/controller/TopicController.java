package com.edifyine.competition.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifyine.competition.pojo.Topic;
import com.edifyine.competition.pojo.TopicResponse;
import com.edifyine.competition.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	
	Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	TopicService topicService;
	
	@GetMapping
	public ResponseEntity<Topic> getTopic(@PathVariable("id") String id){
		logger.info("Entered Get Topic by Topic Id");
		return new ResponseEntity<>(topicService.getTopic(id),HttpStatus.OK);
				
	}
	
	@PostMapping
	public ResponseEntity<Void> saveTopic(@RequestBody Topic topic){
		logger.info("Entered save Topic method");
		topicService.saveTopic(topic);
		return new ResponseEntity<>(HttpStatus.OK);
				
	}
		
	@GetMapping("/all")
	public ResponseEntity<List<TopicResponse>> getAllTopics(){
		logger.info("Entered get all topics method");
		return new ResponseEntity<>(topicService.getAllTopics(),HttpStatus.OK);
				
	}
}
