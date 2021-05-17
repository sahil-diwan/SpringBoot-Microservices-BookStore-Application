package com.pika.userratings;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = { "com.pika.userratings" })
public class JLCUserRatingConfig implements WebMvcConfigurer {
} 