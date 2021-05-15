package com.pika.booksearch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mybookinventory",schema = "jlcbooksdb")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class BookInventory {
	 @Id
	 @Column(name="book_id")
	 private Integer bookId;

	 @Column(name="books_available")
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

