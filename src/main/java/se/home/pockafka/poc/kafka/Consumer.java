package se.home.pockafka.poc.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics ="TOPIC_Message",  groupId = "group_id")
	public void consume(String message) {
		log.info("Message consumed "+message);
	}
	@KafkaListener(topics ="TOPIC_Customer",  groupId = "group_id")
	public void consume(Customer customer) {
		log.info("Message consumed"+customer.toString());
	}
}
