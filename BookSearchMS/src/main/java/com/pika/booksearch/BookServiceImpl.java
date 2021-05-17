package com.pika.booksearch;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService {

	static Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookInventoryDAO bookInventoryDAO;
	@Autowired
	BookRatingDAO bookRatingDAO;
	@Autowired
	BookDAO bookDAO;

	@Override
	public List<Book> getBooks(String author, String category) {
		// TODO Auto-generated method stub
		List<Book> myBooks = new ArrayList<>();
		if(author.equals("All Authors") && category.equals("All Categories")) {
			myBooks = bookDAO.findAll();
			}else if(author.equals("All Authors") && ! category.equals("All Categories")) {
			myBooks = bookDAO.getBooksByCategory(category);
			} else if( ! author.equals("All Authors") && category.equals("All Categories")) {
			myBooks = bookDAO.getBooksByAuthor(author);
			}else {
			myBooks = bookDAO.getBooksByAuthorAndCategory(author, category);
			}
			return myBooks; 
	}

	@Override
	public BookInfo getBookInfo(Integer bookId) {
		// TODO Auto-generated method stub
		BookInfo bookInfo = new BookInfo();

		// Book Details
		Book book = bookDAO.getOne(bookId);
		bookInfo.setBookId(book.getBookId());
		bookInfo.setBookName(book.getBookName());
		bookInfo.setAuthor(book.getAuthor());
		bookInfo.setPublications(book.getPublications());
		bookInfo.setCategory(book.getCategory());

		// Book Price Details :- Here we need to call the
		RestTemplate restTemplate = new RestTemplate();
		String endpoint = "http://localhost:8000/bookPrice/" + bookId;
		BookPriceInfo bpInfo = restTemplate.getForObject(endpoint, BookPriceInfo.class);
		bookInfo.setPrice(bpInfo.getPrice());
		bookInfo.setOffer(bpInfo.getOffer());

		// Book Rating Details

		BookRating bookRating = bookRatingDAO.getBookRatingByBookId(bookId);
		bookInfo.setAvgRating(bookRating.getAvgRating());
		bookInfo.setNumberOfSearches(bookRating.getNumberOfSearches());
		return bookInfo;

	}

	@Override
	public void updateBookRating(BookRating bookRating) {
		// TODO Auto-generated method stub
		bookRatingDAO.save(bookRating); 
	}

	@Override
	public void updateBookInventory(BookInventory bookInventory) {
		// TODO Auto-generated method stub
		bookInventoryDAO.save(bookInventory); 

	}

}
