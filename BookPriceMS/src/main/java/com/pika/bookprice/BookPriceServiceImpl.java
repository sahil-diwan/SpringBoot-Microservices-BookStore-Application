package com.pika.bookprice;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookPriceServiceImpl implements BookPriceService{

	static Logger log=LoggerFactory.getLogger(BookPriceServiceImpl.class); 

	@Autowired
	BookPriceDAO bookPriceDAO;
	
	@Override
	public BookPrice getBookPriceById(Integer bookId) {
		// TODO Auto-generated method stub
		log.info("---BookPriceServiceImpl---getBookPriceById()-----"); 
		BookPrice bookPrice=bookPriceDAO.getOne(bookId);
		return bookPrice; 
	}

	@Override
	public double getOfferedPriceById(Integer bookId) {
		// TODO Auto-generated method stub
		log.info("---BookPriceServiceImpl---getOfferedPriceById()-----"); 
		BookPrice bookPrice=bookPriceDAO.getOne(bookId);
		 double actualPrice=bookPrice.getPrice();
		 double offer=bookPrice.getOffer();
		 if(offer<=0) {
		 return actualPrice;
		 }
		 double discount=actualPrice * offer/100;
		 double offeredPrice=actualPrice - discount;
		 return offeredPrice; 
	}

}
