package com.example.bmdb.builders;


import com.example.bmdb.data.Review;
import com.example.bmdb.data.User;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {
    private String name;
    private  String email;
    private String passWord;
    private List<Review> reviews;

    public UserBuilder() {
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public UserBuilder setReviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public User getUser(){
        return new User(this);
    }
}
