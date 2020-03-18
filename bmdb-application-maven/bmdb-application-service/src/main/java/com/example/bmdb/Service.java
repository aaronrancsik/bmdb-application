package com.example.bmdb;


import com.example.bmdb.builders.DataBuilder;
import com.example.bmdb.data.Media;
import com.example.bmdb.data.Review;
import com.example.bmdb.data.User;

import java.util.List;

public class Service {

    DataBuilder builder;

    public Service() {
        this.builder = new DataBuilder();
        builder.build();
    }

    public DataBuilder getBuilder(){
        return builder;
    }

    public void saveUser(User user){
        this.builder.addUser(user);
    }

    public User findUser(String email, String password)  {
        List<User> a = builder.getUsers();
        return a.stream().filter(u->u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst().get();
    }

    public List<Media> findAllMedia() {
        return this.builder.getMedias();
    }

    public void saveReviews(Media media, Review review){
        review.setMedia(media);
        this.builder.addReview(review);
    }

    public List<Review> findAllReview(Media media) {
        return this.builder.getReviews(media);
    }



}
