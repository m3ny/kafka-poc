package se.home.pockafka.poc.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	private static final Logger log = LoggerFactory.getLogger(Producer.class);
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, String> kTemplate;
	
	public void sendMessage(String message) {
		log.info("Inserting message: "+message);
		kTemplate.send("TOPIC_Message", message);
	}
	public void sendMessage(Customer customer) {
		log.info("Inserting customer"+customer.toString());
		kafkaTemplate.send("TOPIC_Customer", customer);
	}
}
