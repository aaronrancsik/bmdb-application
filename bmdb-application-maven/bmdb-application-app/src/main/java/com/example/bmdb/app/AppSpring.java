package com.example.bmdb.app;


import com.example.bmdb.services.Service;
import com.example.bmdb.data.Media;
import com.example.bmdb.data.Review;
import com.example.bmdb.data.User;
import com.example.bmdb.view.View;

import java.util.List;


public class AppSpring {


    Service service;
    View view;

    User currentUser;
    Media currentMedia;

    public AppSpring(Service service, View view) {
        this.service = service;
        this.view = view;
    }

    private void launch() {
        createUser();
        do{
            doReviews();
        }while (view.questionYesOrNo("Do you want to write another review?"));
        printReviews();
    }

    private void createUser(){
        User u = this.view.readUserData();
        service.saveUser(u);
        this.view.printWelcomeMessage(u);
        currentUser = u;
    }

    private void doReviews(){
        List<Media> medias = this.service.findAllMedia();
        view.printMedias(medias);
        Media selected = view.selectMedia(medias);
        currentMedia = selected;
        Review review = view.writeReview();
        review.setCreator(currentUser);
        selected.addReview(review);
        review.setMedia(selected);
    }

    private void printReviews(){
        view.printReviews(currentMedia);
    }

    public static void main(String[] args) {
	    AppSpring app = new AppSpring(new Service(), new View());
	    app.Play();
    }


}
