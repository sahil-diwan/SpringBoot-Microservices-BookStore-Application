package com.pika.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRatingSender {

	static final Logger logger = LoggerFactory.getLogger(BookRatingSender.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	public void sendBookRating(BookRating bookRating){
		logger.info("BookRatingsSender -- sendBookRating()");
		this.rabbitTemplate.convertAndSend(JLCBeanConfig.RATINGS_QUEUE,bookRating);
	}
	
}
