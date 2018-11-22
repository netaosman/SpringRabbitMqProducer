package com.javasampleapproach.rabbitmq.producer;

import com.javasampleapproach.rabbitmq.model.Currency;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * The main process in the Preducer service.
 * Getting the rabbitMq config details
 * and sending the currencies list to the queue.
 */

@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;

	//Sending the msg to RabbitMq
	public void produce(List<Currency> currenciesList){
		amqpTemplate.convertAndSend(exchange, routingKey, currenciesList);
		System.out.println("Send msg = " + currenciesList);
	}

}

