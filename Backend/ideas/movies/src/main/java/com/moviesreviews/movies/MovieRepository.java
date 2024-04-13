package com.moviesreviews.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //in brackets, we mention the type of data we are dealing with and the type of id.

    Optional<Movie> findMovieByImdbId(String imdbId);



}
