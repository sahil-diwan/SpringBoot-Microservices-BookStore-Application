package com.pika.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="myplaceholder",url="https://jsonplaceholder.typicode.com/")
public interface MyRestServiceProxy {
	
	@GetMapping("/posts/{postId}")
	public Post getPostById(@PathVariable("postId") int postId);

}
