package com.moviesreviews.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    //means we let the framework know that it instantiate movieRepo class here
    private MovieRepository movieRepository;

    //we will write database access methods
    public List<Movie> allMovies(){
       // System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId){
        //optional is used to handle null values as there might be the case when we ont
        //have any movie with passed id.
        return movieRepository.findMovieByImdbId(imdbId);
        //findAll and findById all are mongoRepo class' inbuilt function which our
        //movierepo class is extending as an interface.
    }
}
