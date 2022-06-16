package com.edifyine.competition.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsoupHtmlCrawler {
	
	@Autowired
	BlockingQueue<String> msgQueue;
	
	public void startScrapping() {
		String url = "https://www.interviewbit.com/java-interview-questions/";
		crawl(1, url, new ArrayList<String>());	
	}

	private void crawl(int level, String url, ArrayList<String> visited) {
		if(level <=1) {
			Document doc = request(url,visited);
			
			if(doc != null) {
				//doc.select("doc.select("[href]")")
				for(Element link : doc.getElementsByClass("ibpage-article-header")) {
					String question = link.getElementsByTag("h3").html();
					String answer = link.getElementsByClass("ibpage-article").html();
					/*if(!visited.contains(nextLink)) {
						crawl(++level, nextLink,visited);
					}*/
					System.out.println("question::"+question);
					System.out.println("answer::"+answer);
					msgQueue.add("question::"+question+" answer::"+answer);
					System.out.println();
				}
			}
		}
		
	}

	private Document request(String url, ArrayList<String> visited) {
		Connection connection = Jsoup.connect(url);
		connection.userAgent("Mozilla/48.0");
		connection.timeout(5000);
		connection.cookie("cookiename", "val234");
		connection.referrer("http://google.com");
		connection.header("headersecurity", "xyz123");
		try {
			Document doc = connection.get();
			if(connection.response().statusCode() == 200) {
				System.out.println("Link:"+ url);
				if(url.endsWith("#")) {
					url = url.substring(0, url.length()-2);
				}
				//System.out.println(doc.title());
				//System.out.println("New url:"+url);
				visited.add(url);
				return doc;
			}
			System.out.println(connection.response().statusCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
