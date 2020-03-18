package com.example.bmdb.builders;


import com.example.bmdb.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DataBuilder {
    private List<Media> medias;
    private List<Actor> actors;
    private List<User> users;
    private List<Review> reviews;

    public DataBuilder() {
        this.medias = new ArrayList<>();
        this.actors = new ArrayList<>();
        this.users = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public List<Media> getMedias() {
        return Collections.unmodifiableList(medias);
    }

    public List<Actor> getActors() {
        return Collections.unmodifiableList(actors);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public List<Review> getReviews(Media media) {
        return Collections.unmodifiableList(reviews.stream().filter(r -> r.getMedia().equals(media)).collect(Collectors.toList()));
    }

    public DataBuilder addReview(Review review) {
        this.reviews.add(review);
        return this;
    }

    public DataBuilder addUser(User user) {
        this.users.add(user);
        return this;
    }


    public void build() {
        this.buildUsers();
        this.buildActors();
        this.buildMedias();
        this.buildReviews();
    }

    private void buildUsers() {
        this.users.add(new UserBuilder()
                .setName("Alma")
                .setEmail("alma@ealma.com")
                .setPassword("batman")
                .getUser());
        this.users.add(new UserBuilder()
                .setName("Banana")
                .setEmail("banan@banan.com")
                .setPassword("beethoven")
                .getUser());
        this.users.add(new UserBuilder()
                .setName("Peel")
                .setEmail("peel@peel.com")
                .setPassword("brown")
                .getUser());
    }

    private void buildActors() {
        this.actors.add(new ActorBuilder()
                .setName("Actor 1")
                .setBorn(LocalDate.of(1910, 1, 11))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 1")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 2")
                .setBorn(LocalDate.of(1920, 2, 12))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 2")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 3")
                .setBorn(LocalDate.of(1930, 3, 13))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 3")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 4")
                .setBorn(LocalDate.of(1940, 4, 14))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 4")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 5")
                .setBorn(LocalDate.of(1950, 5, 15))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 5")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 6")
                .setBorn(LocalDate.of(1960, 6, 16))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 6")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 7")
                .setBorn(LocalDate.of(1970, 7, 17))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 7")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 8")
                .setBorn(LocalDate.of(1980, 8, 18))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 8")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 9")
                .setBorn(LocalDate.of(1990, 9, 19))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 9")
                .getActor());

        this.actors.add(new ActorBuilder()
                .setName("Actor 10")
                .setBorn(LocalDate.of(2000, 10, 20))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 10")
                .getActor());
    }

    private void buildMedias() {
        this.medias.add(new MediaBuilder()
                .setId(BigDecimal.valueOf(1))
                .setTitle("Movie 1")
                .setDescription("Super description 1")
                .setPremier(LocalDate.of(2011, 1, 20))
                .addCast(this.actors.get(0))
                .addCast(this.actors.get(1))
                .getSeries());

        this.medias.add(new MediaBuilder()
                .setId(BigDecimal.valueOf(2))
                .setTitle("Movie 2")
                .setDescription("Super description 2")
                .setPremier(LocalDate.of(2012, 2, 22))
                .addCast(this.actors.get(2))
                .addCast(this.actors.get(3))
                .getMovie());

        this.medias.add(new MediaBuilder()
                .setId(BigDecimal.valueOf(3))
                .setTitle("Movie 3")
                .setDescription("Super description 3")
                .setPremier(LocalDate.of(2013, 3, 23))
                .addCast(this.actors.get(4))
                .addCast(this.actors.get(5))
                .getSeries());

        this.medias.add(new MediaBuilder()
                .setId(BigDecimal.valueOf(4))
                .setTitle("Movie 4")
                .setDescription("Super description 4")
                .setPremier(LocalDate.of(2014, 4, 24))
                .addCast(this.actors.get(6))
                .addCast(this.actors.get(7))
                .getMovie());

        this.medias.add(new MediaBuilder()
                .setId(BigDecimal.valueOf(5))
                .setTitle("Movie 5")
                .setDescription("Super description 5")
                .setPremier(LocalDate.of(2015, 5, 15))
                .addCast(this.actors.get(8))
                .addCast(this.actors.get(9))
                .getSeries());
    }

    private void buildReviews() {
        this.reviews.add(new ReviewBuilder()
                .setText("")
                .setCreator(this.users.get(0))
                .setMedia(this.medias.get(0))
                .setRating(Rating.GOOD)
                .getReview());

        this.reviews.add(new ReviewBuilder()
                .setText("")
                .setCreator(this.users.get(0))
                .setMedia(this.medias.get(1))
                .setRating(Rating.BAD)
                .getReview());

        this.reviews.add(new ReviewBuilder()
                .setText("")
                .setCreator(this.users.get(1))
                .setMedia(this.medias.get(2))
                .setRating(Rating.AVERAGE)
                .getReview());

        this.reviews.add(new ReviewBuilder()
                .setText("")
                .setCreator(this.users.get(1))
                .setMedia(this.medias.get(3))
                .setRating(Rating.GOOD)
                .getReview());

        this.reviews.add(new ReviewBuilder()
                .setText("")
                .setCreator(this.users.get(2))
                .setMedia(this.medias.get(4))
                .setRating(Rating.BAD)
                .getReview());

        this.reviews.add(new ReviewBuilder()
                .setText("")
                .setCreator(this.users.get(2))
                .setMedia(this.medias.get(4))
                .setRating(Rating.AVERAGE)
                .getReview());
    }


}
