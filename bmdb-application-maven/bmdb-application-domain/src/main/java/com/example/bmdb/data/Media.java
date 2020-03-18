package com.example.bmdb.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Media {
    protected BigDecimal id;
    protected String title;
    protected String description;
    protected LocalDate premier;
    protected List<Review> reviews;
    protected List<Actor> cast;

    public Media(BigDecimal id, String title, String description, LocalDate premier) {
        setId(id);
        setTitle(title);
        setDescription(description);
        setPremier(premier);
        this.reviews = new ArrayList<>();
        this.cast = new ArrayList<>();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPremier() {
        return premier;
    }

    public void setPremier(LocalDate premier) {
        this.premier = premier;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public List<Actor> getCast() { return cast; }

    public void addCast(Actor actor){
        this.cast.add(actor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(id, media.id) &&
                Objects.equals(title, media.title) &&
                Objects.equals(description, media.description) &&
                Objects.equals(premier, media.premier) &&
                Objects.equals(reviews, media.reviews) &&
                Objects.equals(cast, media.cast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, premier, reviews, cast);
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", premier=" + premier +
                ",\n reviews=" + reviews.stream().map(Objects::toString).collect(Collectors.joining(", ")) +
                ",\n cast=" + cast.stream().map(Objects::toString).collect(Collectors.joining(", ")) +
                "\n}";
    }
}
