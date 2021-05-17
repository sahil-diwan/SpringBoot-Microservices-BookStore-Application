package com.pika.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="myBookPriceMS",url="http://localhost:8000/")
public interface MyBookPriceServiceProxy {
	
	@GetMapping("/bookPrice/{bookId}")
	public BookPrice getBookPrice(@PathVariable("bookId") Integer bookId);
	
	@GetMapping("/offeredPrice/{bookId}")
	public double getOfferedPrice(@PathVariable("bookId") Integer bookId);

}
