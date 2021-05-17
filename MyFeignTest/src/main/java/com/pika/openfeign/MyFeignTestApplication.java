package com.pika.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients(basePackageClasses={com.pika.openfeign.MyBookPriceServiceProxy.class,com.pika.openfeign.MyRestServiceProxy.class})
public class MyFeignTestApplication implements CommandLineRunner{

	@Autowired
	MyRestServiceProxy myRestServiceProxy;
	
	@Autowired
	MyBookPriceServiceProxy myBookPriceServiceProxy;
	
	public static void main(String[] args) {
		SpringApplication.run(MyFeignTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//Using Rest Template
		RestTemplate restTemplate = new RestTemplate();
		String endPoint = "https://jsonplaceholder.typicode.com/posts/100";
		Post myPost = restTemplate.getForObject(endPoint, Post.class);
		System.out.println(myPost);
		
		//Using FeignClient
		Post myPost1 = myRestServiceProxy.getPostById(100);
		System.out.println(myPost1);
		
		Post myPost2 = myRestServiceProxy.getPostById(1);
		System.out.println(myPost2);
		
		
		BookPrice bookPrice= myBookPriceServiceProxy.getBookPrice(101);
		System.out.println(bookPrice);
		
		double offer = myBookPriceServiceProxy.getOfferedPrice(101);
		System.out.println(offer);
		System.out.println("Done");
	}

}
