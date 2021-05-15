package com.pika.placeorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
	
	static Logger log=LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	OrderItemDAO orderItemDAO;
	@Autowired
	BookInventoryDAO bookInventoryDAO; 
	
	@Override
	public void placeOrder(OrderInfo orderInfo) {
		log.info("---OrderServiceImpl---placeOrder()-----");
		Order myorder=orderInfo.getOrder();
		myorder=orderDAO.save(myorder);//1002
		int orderId=myorder.getOrderId();
		for(OrderItem myitem:orderInfo.getItemsList()) {
			myitem.setOrderId(orderId);
			orderItemDAO.save(myitem);
		}
		
		//Update Local Inventory
		//Update Inventory of BookSearchMS.
		RestTemplate bookSearchRest=new RestTemplate();
		String endpoint="http://localhost:5000/updateBookInventory";
		for(OrderItem myitem:orderInfo.getItemsList()) {
			Integer bookId = myitem.getBookId();
			BookInventory bookInventory=bookInventoryDAO.getOne(bookId);
			bookInventory.setBooksAvailable(bookInventory.getBooksAvailable()-1);
			// Local Inventory
			bookInventoryDAO.save(bookInventory);
			//Inventory of BookSearchMS.
			bookSearchRest.put(endpoint, bookInventory); 

		}

	}
}
