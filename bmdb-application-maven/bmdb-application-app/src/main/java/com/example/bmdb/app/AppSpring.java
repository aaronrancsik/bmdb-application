package com.example.bmdb.app;


import com.example.bmdb.services.Service;
import com.example.bmdb.config.AppConfig;
import com.example.bmdb.data.Media;
import com.example.bmdb.data.Review;
import com.example.bmdb.data.User;
import com.example.bmdb.view.View;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppSpring {

    private static Logger log = LoggerFactory.getLogger(AppSpring.class);

    private Service service;
    private View view;

    @Inject
    public void setService(Service service) {
        log.info("setGeneralService");
        this.service = service;
    }

    @Inject
    public void setView(View view) {
        log.info("setView");
        this.view = view;
    }


    private void launch() {
        log.info("launch");
        User user = createUser();
        List<Media> medias = service.findAllMedia();
        do{
            view.printMedias(medias);
            Media selected = selectMedia(medias);
            doReviews(user, selected);
        }while (view.anotherReviewFromConsole());

        view.printMedias(medias);
        Media selected = selectMedia(medias);
        averageReviews(selected);
    }

    private User createUser(){
        log.info("createUser");
        User user = this.view.readUserData();
        service.saveUser(user);
        this.view.printWelcomeMessage(user);
        return user;
    }

    private Media selectMedia(List<Media> medias){
        log.info("selectMedia");
        return medias.get(view.getMediaNumberFromConsole());
    }


    private void doReviews(User user, Media media){
        log.info("doReviews");
        Review review = view.getReviewFromConsole();
        service.saveReview(media,review,user);

    }

    private void averageReviews(Media selected){
        log.info("averageReviews");
        view.averageReviewsToConsole(service.getAverageRating(selected));
    }

    public static void main(String[] args) {
        try(ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)){
            AppSpring app = appContext.getBean(AppSpring.class);
            app.launch();
        }
    }
}
