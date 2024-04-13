package com.moviesreviews.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String imdbId){
        Reviews review = reviewRepository.insert(new Reviews(reviewBody));

        //insert is mongo repo's inbuilt method and will return what you just inserted.

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                //means we are updating the movie which has same imdb as supplied by user
                .apply(new Update().push("reviewIds").value(review))
                .first();
                //then we apply this change and update this in database corresponds to reviewId
        return review;
    }
}
