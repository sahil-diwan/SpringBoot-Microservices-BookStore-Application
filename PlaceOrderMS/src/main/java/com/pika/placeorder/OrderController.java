package com.pika.placeorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin //CORS
@RestController
public class OrderController {
	static Logger log=LoggerFactory.getLogger(OrderController.class);
	 @Autowired
	 OrderService orderService;

	 @PutMapping("/placeOrder")
	 public void placeOrder(@RequestBody OrderInfo orderInfo){
	 log.info("---OrderController---placeOrder()-----");
	 orderService.placeOrder(orderInfo);
	 }
}
