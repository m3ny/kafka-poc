package se.home.pockafka.poc.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Customer {
	private String name;
	private int age;
	private String id;
}
