package se.home.pockafka.poc.kafka;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/kafka")
public class KafkaController {
	private static final Logger log = LoggerFactory.getLogger(KafkaController.class);
	
	@Autowired
	Producer producer;
	
	@PostMapping(value="/publishMessage/{message}")
	public void sendMessageToTopic(@PathVariable("message") String message) {
		log.info("Sending message to producer");
		producer.sendMessage(message);
	}
	@PostMapping(value="/publishCustomer/{name}")
	public void sendCustomerToTopic(@PathVariable("name") String name) {
		log.info("Sending message to producer");
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		producer.sendMessage(new Customer(name, 12, id));
	}

}
