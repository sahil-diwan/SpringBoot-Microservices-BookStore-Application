package com.pika.bookprice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = { "com.pika.bookprice" })
public class JLCBookPriceConfig implements WebMvcConfigurer {

} 
