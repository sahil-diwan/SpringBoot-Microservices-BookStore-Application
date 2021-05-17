package com.pika.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JLCBeanConfig {

	public static final String RATINGS_QUEUE="myratings-queue";
	public static final String RATINGS_EXCHANGE="myratings-exchange";
	
	public static final String INVENTORY_QUEUE="myinventory-queue";
	public static final String INVENTORY_EXCHANGE="myinventory-exchange";
	
	@Bean(name="myRatingsQueue")
	Queue createRatingsQueue(){
		return QueueBuilder.durable(RATINGS_QUEUE).build();
	}
	
	@Bean(name="myInventoryQueue")
	Queue createInventoryQueue(){
		return QueueBuilder.durable(INVENTORY_QUEUE).build();
	}
	
	@Bean(name="myRatingsExchange")
	Exchange createRatingsExchange(){
		return ExchangeBuilder.topicExchange(RATINGS_EXCHANGE).build();
	}
	
	@Bean(name="myInventoryExchange")
	Exchange createInventoryExchange(){
		return ExchangeBuilder.topicExchange(INVENTORY_EXCHANGE).build();
	}
	
	Binding ratingBinding(Queue myRatingsQueue,TopicExchange myRatingsExchange){
		return BindingBuilder.bind(myRatingsQueue).to(myRatingsExchange).with(RATINGS_QUEUE);
	}
	
	Binding inventoryBinding(Queue myInventoryQueue,TopicExchange myInventoryExchange){
		return BindingBuilder.bind(myInventoryQueue).to(myInventoryExchange).with(INVENTORY_QUEUE);
	}
	
	
	
}
