package com.pika.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookInventorySender {
	static final Logger logger = LoggerFactory.getLogger(BookRatingSender.class);
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void sendBookInventory(BookInventory bookInventory){
		logger.info("BookRatingSender -- sendBookInventory()");
		this.rabbitTemplate.convertAndSend(JLCBeanConfig.INVENTORY_QUEUE,bookInventory);
	}

}
