package com.pika.booksearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = { "com.pika.booksearch" })
public class JLCBookSearchConfig implements WebMvcConfigurer {

}
