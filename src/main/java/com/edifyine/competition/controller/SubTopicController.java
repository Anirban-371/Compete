package com.edifyine.competition.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifyine.competition.pojo.SubTopic;
import com.edifyine.competition.service.TopicService;

@RestController
@RequestMapping("/subTopic")
public class SubTopicController {
	
	Logger logger = LoggerFactory.getLogger(SubTopicController.class);
	
	@Autowired
	TopicService topicService;
	
	@GetMapping
	public ResponseEntity<List<SubTopic>> getTopicSubTopic(@PathVariable("topicId") String topicId){
		logger.info("Get Subtopics by Topic Id");
		return new ResponseEntity<>(topicService.getTopicSubTopic(topicId),HttpStatus.OK);
				
	}
	
	@PostMapping("/{topicId}")
	public ResponseEntity<Void> saveSubTopicByTopic(@RequestBody List<SubTopic> subTopicList, @PathVariable("topicId") String topicId){
		logger.info("Save Subtopics against the topic:" + topicId);
		topicService.saveSubTopicByTopic(topicId, subTopicList);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@PutMapping("/{subtopicId}")
	public ResponseEntity<Void> updateSubTopic(@RequestBody SubTopic subTopic, @PathVariable("subTopicId") String subTopicId){
		logger.info("Update subtopic:" + subTopicId);
		topicService.updateSubTopic(subTopicId, subTopic);
		return new ResponseEntity<>(HttpStatus.OK);		
	}

}
