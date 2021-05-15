package com.pika.userratings;

import java.util.List;

public interface RatingService {

	public void addUserRating(UserRating userRating);

	public List<UserRating> getUserRatingByBookId(Integer bookId);

	public List<UserRating> getUserRatingByUserId(String userId);

	public void updateBookRating(BookRating bookRating);

	public BookRating getBookRatingByBookId(Integer bookId);
}
