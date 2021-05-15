package com.pika.bookprice;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookPriceMsApplication {
	static Logger log=LoggerFactory.getLogger(BookPriceMsApplication.class); 
	
	public static void main(String[] args) {
		log.info(" BookPriceMS - Begin "); 
		SpringApplication.run(BookPriceMsApplication.class, args);
		log.info(" BookPriceMS - End ");
	}

}
