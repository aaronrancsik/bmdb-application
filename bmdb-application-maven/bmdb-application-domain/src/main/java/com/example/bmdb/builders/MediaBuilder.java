package com.example.bmdb.builders;


import com.example.bmdb.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MediaBuilder {

    protected BigDecimal id;
    protected String title;
    protected String description;
    protected LocalDate premier;
    protected List<Review> reviews;
    protected List<Actor> cast;

    public MediaBuilder() {
        this.reviews = new ArrayList<>();
        this.cast = new ArrayList<>();
    }

    public Media getMedia() {
        Media media = new Media(this.id, this.title, this.description, this.premier);
        for (Review review : this.reviews) {
            media.addReview(review);
        }
        for (Actor actor : this.cast) {
            media.addCast(actor);
        }
        return media;
    }

    public Series getSeries() {
        Series series = new Series(this.id, this.title, this.description, this.premier);
        for (Review review : this.reviews) {
            series.addReview(review);
        }
        for (Actor actor : this.cast) {
            series.addCast(actor);
        }
        return series;
    }

    public Movie getMovie() {
        Movie movie = new Movie(this.id, this.title, this.description, this.premier);
        for (Review review : this.reviews) {
            movie.addReview(review);
        }
        for (Actor actor : this.cast) {
            movie.addCast(actor);
        }
        return movie;
    }

    public BigDecimal getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPremier() {
        return premier;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public MediaBuilder setId(BigDecimal id) {
        this.id = id;
        return this;
    }

    public MediaBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MediaBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public MediaBuilder setPremier(LocalDate premier) {
        this.premier = premier;
        return this;
    }

    public MediaBuilder setReviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public MediaBuilder addReview(Review review){
        this.reviews.add(review);
        return this;
    }

    public MediaBuilder addCast(Actor actor) {
        this.cast.add(actor);
        return this;
    }

}
