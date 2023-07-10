package com.cdac.movies.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableUpdateOperation.ExecutableUpdate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.cdac.movies.pojo.Review;
import com.cdac.movies.repository.ReviewRepository;
import  com.cdac.movies.pojo.Movie;
@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Review createReview(String reviewBody, String imdbId) {
		Review review =reviewRepository.insert(new Review(reviewBody));
		
		
		
		mongoTemplate.update(Movie.class)//ExecutableUpdate<Movie>;
			.matching(Criteria.where("imdbId").is(imdbId))//UpdateWithUpdate<Movie>
			.apply(new Update().push("reviewIds").value(review))//TerminatingUpdate<Movie>;
			.first();
		
		 return review;
	}
	 

}
