package com.pika.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BookRatingListner {

	static final Logger logger = LoggerFactory.getLogger(BookRatingSender.class);
	
	@RabbitListener(queues=JLCBeanConfig.RATINGS_QUEUE)
	public void updateBookRating(BookRating bookRating){
		logger.info("BookRatingSender-updateBookRating()");
		logger.info("-------------");
		logger.info("BookRatingReceived: "+bookRating);
		logger.info("------------");
	}
}
