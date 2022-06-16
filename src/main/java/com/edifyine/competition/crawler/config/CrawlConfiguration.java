package com.edifyine.competition.crawler.config;

import java.io.File;

import com.edifyine.competition.crawler.HTLMCrawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class CrawlConfiguration {
	/*public static void main(String[] args) {
		File crawlStorage = new File("src/main/resources/crawler4j");
		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorage.getAbsolutePath());
		config.setResumableCrawling(true);
		int numCrawlers = 1;

		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer= new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller;
		try {
			controller = new CrawlController(config, pageFetcher, robotstxtServer);
			controller.addSeed("https://www.baeldung.com/");

			CrawlController.WebCrawlerFactory<HTLMCrawler> factory = HTLMCrawler::new;

			controller.start(factory, numCrawlers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}

		
	}*/
}
