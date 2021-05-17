package com.pika.bookstoreweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreWebApplication {
	static Logger log=LoggerFactory.getLogger(BookStoreWebApplication.class); 
	public static void main(String[] args) {
		SpringApplication.run(BookStoreWebApplication.class, args);
		log.info(" StartMyBookStoreWeb - Launched.... "); 

	}

}
