package com.pika.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BookInventoryListner {

	static final Logger logger = LoggerFactory.getLogger(BookRatingSender.class);
	
	@RabbitListener(queues=JLCBeanConfig.INVENTORY_QUEUE)
	public void updateBookInventory(BookInventory bookInventory){
		logger.info("Book Inventory Listener -- updateBookInventory");
		logger.info("----------------");
		logger.info("Book Inventory Received :"+bookInventory);
		logger.info("----------------");
	}
}
