package com.pika.userratings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	 BookRatingDAO bookRatingDAO;

	 @Autowired
	 UserRatingDAO userRatingDAO; 

	@Override
	public void addUserRating(UserRating userRating) {

		//1.Add the User Rating
		 userRatingDAO.save(userRating);

		 //2.Calculate the Avg rating for BookId
		 int bookId=userRating.getBookId();
		 List<UserRating> ratingList=this.getUserRatingByBookId(bookId);

		 double sumRating=0.0;
		 for(UserRating ur : ratingList) {
		 sumRating=sumRating+ur.getRating();
		 }
		 double avgRating=sumRating/ratingList.size();

		 //3.Update BookRating in UserRatingMS (Local)
		 BookRating bookRating=this.getBookRatingByBookId(bookId);
		 bookRating.setAvgRating(avgRating);
		 this.updateBookRating(bookRating);

		 //4.Update BookRating in BookSearchMS
		 //Invoking BookRating-MS
		 RestTemplate bookSearchRest=new RestTemplate();
		 String endpoint="http://localhost:5000/updateBookRating";
		 bookSearchRest.put(endpoint, bookRating); 

	}

	@Override
	public List<UserRating> getUserRatingByBookId(Integer bookId) {
		return userRatingDAO.getUserRatingByBookId(bookId);
	}

	@Override
	public List<UserRating> getUserRatingByUserId(String userId) {
		return userRatingDAO.getUserRatingByUserId(userId);
	}

	@Override
	public void updateBookRating(BookRating bookRating) {
		bookRatingDAO.save(bookRating); 

	}

	@Override
	public BookRating getBookRatingByBookId(Integer bookId) {
		BookRating bookRating=bookRatingDAO.getBookRatingByBookId(bookId);
		return bookRating; 

	}

}
