package com.moviesreviews.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reviews")
//in brackets we have collections name and we haven't created this collection ourself but
//springboot will itself create one for us with this name.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {

    @Id
    private ObjectId id;
    private String body;

    public Reviews(String body) {
        this.body = body;
    }
}
