package com.pika.userratings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRatingDAO extends JpaRepository<UserRating, Integer> {
	public List<UserRating> getUserRatingByBookId(Integer bookId);

	public List<UserRating> getUserRatingByUserId(String userId);
}
