package com.moviesreviews.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
//changed according to comments
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Map<String, String> payLoad){
        //whatever we get as a request body, we would like it to convert to Map of string and  string as
        //key value pair
        return new ResponseEntity<Reviews>(reviewService.createReview(payLoad.get("reviewBody"), payLoad.get("imdbId")), HttpStatus.CREATED);
        //created mean status = 201.
    }
}
