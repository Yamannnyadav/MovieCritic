package com.moviesreviews.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
//it means the following class represents MongoDb document
@Data
//comes from lombok project and it takes care of all getters and setters'
@AllArgsConstructor
//this will save us from writing constructors for all provided arguements
@NoArgsConstructor
//will create constructors which doesn't take parameters
public class Movie {

    @Id
    private ObjectId id;
    //unique identifier for each movie.

    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    //Due to this, database will only store the ids of the reviews and the reviews will
    //be in seperate collection.
    private List<Reviews> reviewIds;

}
