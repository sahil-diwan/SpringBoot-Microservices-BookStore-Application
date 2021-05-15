package com.pika.booksearch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mybooks",schema = "jlcbooksdb")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="book_id")
 private Integer bookId;

 @Column(name="book_name")
 private String bookName;

 @Column(name="author")
 private String author;

 @Column(name="publications")
 private String publications;

 @Column(name="category")
 private String category;

public Book() {
	super();
	// TODO Auto-generated constructor stub
}

public Book(Integer bookId, String bookName, String author, String publications, String category) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.author = author;
	this.publications = publications;
	this.category = category;
}

public Integer getBookId() {
	return bookId;
}

public void setBookId(Integer bookId) {
	this.bookId = bookId;
}

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getPublications() {
	return publications;
}

public void setPublications(String publications) {
	this.publications = publications;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

 
 
} 
