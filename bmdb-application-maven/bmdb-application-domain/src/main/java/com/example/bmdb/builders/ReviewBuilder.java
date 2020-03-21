package com.example.bmdb.builders;

import com.example.bmdb.data.Media;
import com.example.bmdb.data.Rating;
import com.example.bmdb.data.Review;
import com.example.bmdb.data.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ReviewBuilder {

    private String text;
    private Media media;
    private User creator;
    private Rating rating;

    public ReviewBuilder() {
    }

    public String getText() {
        return text;
    }

    public Media getMedia() {
        return media;
    }

    public User getCreator() {
        return creator;
    }

    public Rating getRating() {
        return rating;
    }

    public ReviewBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public ReviewBuilder setMedia(Media media) {
        this.media = media;
        return this;
    }

    public ReviewBuilder setCreator(User creator) {
        this.creator = creator;
        return this;
    }

    public ReviewBuilder setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public Review getReview(){
        return new Review(this);
    }
}
