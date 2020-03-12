package Model;

import Model.Builders.ReviewBuilder;

import java.util.Objects;

public class Review {
    private String text;
    private Media media;
    private User creator;
    private Rating rating;

    public Review(String text, Media media, User creator, Rating rating) {
        this.text = text;
        this.media = media;
        this.creator = creator;
        this.rating = rating;
    }

    public Review(ReviewBuilder reviewBuilder) {
        setText(reviewBuilder.getText());
        setMedia(reviewBuilder.getMedia());
        setCreator(reviewBuilder.getCreator());
        setRating(reviewBuilder.getRating());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
        if(media!=null){
            media.addReview(this);
        }
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
        if(creator!=null){
            creator.addReview(this);
        }
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(text, review.text) &&
                Objects.equals(media, review.media) &&
                Objects.equals(creator, review.creator) &&
                rating == review.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, media, creator, rating);
    }

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                ", rating=" + rating +
                '}';
    }
}
