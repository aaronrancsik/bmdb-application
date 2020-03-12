package Application;

import Model.Builders.DataBuilder;
import Model.Media;
import Model.Review;
import Model.User;

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
        var a = builder.getUsers();
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
