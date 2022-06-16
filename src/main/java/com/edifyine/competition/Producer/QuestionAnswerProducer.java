package com.edifyine.competition.Producer;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edifyine.competition.crawler.JsoupHtmlCrawler;
import com.edifyine.competition.service.QuestionAnswerProducerService;

@Component
public class QuestionAnswerProducer implements QuestionAnswerProducerService {
	
	@Autowired
	BlockingQueue<String> msgQueue;
	
	@Autowired
	Properties properties;
	
	String bootStrapServers="127.0.0.1:9092";
	static Logger logger = LoggerFactory.getLogger(QuestionAnswerProducer.class.getName());
	
	public void produce() {
		run();
	}

	private void run() {
		Properties properties = new Properties();

        /*properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,"true");
        properties.setProperty(ProducerConfig.ACKS_CONFIG,"all");  
        properties.setProperty(ProducerConfig.RETRIES_CONFIG,Integer.toString(Integer.MAX_VALUE));
        properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,"5");

        properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG,"snappy");
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG,"20");
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,Integer.toString((32*1024)));
        */
		properties = this.properties;
		
        //create the producer
        KafkaProducer<String, String> producer =  new KafkaProducer<String, String>(properties);
        
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            logger.info("stopping application");
            logger.info("closing producer...");
            producer.close();
            logger.info("done!");
        }));
        while(!msgQueue.isEmpty()) {
        	String msg = null;
        	try {
        		msg = msgQueue.poll(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if(msg != null){
                logger.info(msg);
                producer.send(new ProducerRecord<>("question_answer_topic", null, msg), new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        if(e!=null){
                            logger.info("something happened", e);
                        }
                    }
                });
            }
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
	}

	@Override
	public void testproducer() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
