package com.edifyine.competition.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifyine.competition.crawler.JsoupHtmlCrawler;
import com.edifyine.competition.service.QuestionAnswerProducerService;

@RestController
@RequestMapping("/scrapper")
public class ScrapperController {
	Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	
	JsoupHtmlCrawler crawler;
	
	@Autowired
	QuestionAnswerProducerService questionAnswerProducerService;
	
	@GetMapping
	public ResponseEntity<Void> startScrapping(){
		logger.info("Entered Get Topic by Topic Id");
		crawler = new JsoupHtmlCrawler();
		crawler.startScrapping();
		questionAnswerProducerService.produce();
		return new ResponseEntity<>(HttpStatus.OK);
				
	}
	
	
	@PostMapping
	public ResponseEntity<Void> testproducer(){
		logger.info("Testing the Producer");
		questionAnswerProducerService.testproducer();
		questionAnswerProducerService.produce();
		return new ResponseEntity<>(HttpStatus.OK);
				
	}
	

}
