package com.example.bmdb.data;

import com.example.bmdb.builders.UserBuilder;
import java.util.List;
import java.util.Objects;


public class User {
    private String name;
    private  String email;
    private String password;
    private List<Review> reviews;


    public User(UserBuilder builder) {
        setName(builder.getName());
        setEmail(builder.getEmail());
        setPassword(builder.getPassWord());
        setReviews(builder.getReviews());
    }

    public User(String name, String email, String password, List<Review> reviews) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setReviews(reviews);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(reviews, user.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, reviews);
    }
}
