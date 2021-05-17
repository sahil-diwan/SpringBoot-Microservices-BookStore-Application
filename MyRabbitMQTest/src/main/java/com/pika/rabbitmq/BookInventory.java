package com.pika.rabbitmq;

import java.io.Serializable;

public class BookInventory implements Serializable{

	private Integer bookId;
	private int booksAvailable;
	public BookInventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookInventory(Integer bookId, int booksAvailable) {
		super();
		this.bookId = bookId;
		this.booksAvailable = booksAvailable;
	}
	@Override
	public String toString() {
		return "BookInventory [bookId=" + bookId + ", booksAvailable=" + booksAvailable + "]";
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public int getBooksAvailable() {
		return booksAvailable;
	}
	public void setBooksAvailable(int booksAvailable) {
		this.booksAvailable = booksAvailable;
	}
	
	
}
