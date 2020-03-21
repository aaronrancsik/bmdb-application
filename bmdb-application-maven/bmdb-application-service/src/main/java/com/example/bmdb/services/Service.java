package com.example.bmdb.services;


import com.example.bmdb.data.Media;
import com.example.bmdb.data.Review;
import com.example.bmdb.data.User;
//import org.springframework.stereotype.Service;


import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    List<User> users;
    @Inject
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void saveUser(User user){
        this.users.add(user);
    }
    public User findUser(String email, String password)  {
        return users.stream().filter(u->u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst().get();
    }

    List<Media> medias;
    @Inject
    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }
    public List<Media> findAllMedia() {
        return Collections.unmodifiableList(medias);
    }

    List<Review> reviews;
    @Inject
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public void saveReview(Media media, Review review, User user){
        review.setCreator(user);
        review.setMedia(media);
        media.addReview(review);
        this.reviews.add(review);
    }
    public List<Review> findAllReview(Media media) {
        return Collections.unmodifiableList(reviews);
    }

    public double getAverageRating(Media selected){
        double sum = selected.getReviews().stream().mapToInt(o->o.getRating().rate).sum();
        double num = selected.getReviews().stream().count();
        return  sum / num;

    }



}
