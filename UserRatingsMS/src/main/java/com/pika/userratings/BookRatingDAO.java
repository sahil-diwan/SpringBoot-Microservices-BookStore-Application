package com.pika.userratings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRatingDAO extends JpaRepository<BookRating, Integer> {
	public BookRating getBookRatingByBookId(Integer bookId);
}
