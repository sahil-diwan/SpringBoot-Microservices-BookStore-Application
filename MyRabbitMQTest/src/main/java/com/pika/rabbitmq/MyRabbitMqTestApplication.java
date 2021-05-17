package com.pika.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyRabbitMqTestApplication implements CommandLineRunner{

	static final Logger logger = LoggerFactory.getLogger(BookRatingSender.class);
	
	@Autowired
	BookRatingSender bookRatingSender;
	
	@Autowired
	BookInventorySender bookInventorySender;
	
	public static void main(String[] args) {
		SpringApplication.run(MyRabbitMqTestApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Rabbit MQ Test Application Launched");
		
		logger.info("Sending BookRating Messafe --- Started");
		BookRating rating1 = new BookRating(101,4.5,99);
		bookRatingSender.sendBookRating(rating1);
		
		BookRating rating2 = new BookRating(102,4.9,99);
		bookRatingSender.sendBookRating(rating2);
		
		logger.info("Sending BookRating Message --- Completed");
		
		
		logger.info("Sending BookInventory Message --- Started");
		BookInventory inventory1 = new BookInventory(101,50);
		bookInventorySender.sendBookInventory(inventory1);
		
		BookInventory inventory2 = new BookInventory(102,90);
		bookInventorySender.sendBookInventory(inventory2);
		
		logger.info("Sending BookInventory Message --- Completed");
		
		
		}

}
