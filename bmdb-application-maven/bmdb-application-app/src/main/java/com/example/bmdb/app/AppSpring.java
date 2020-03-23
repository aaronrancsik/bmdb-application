package com.example.bmdb.app;


import com.example.bmdb.models.Actor;
import com.example.bmdb.models.Media;
import com.example.bmdb.models.Review;
import com.example.bmdb.models.User;
import com.example.bmdb.config.AppConfig;
import com.example.bmdb.services.*;
import com.example.bmdb.view.View;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class AppSpring {

    private static Logger log = LoggerFactory.getLogger(AppSpring.class);

    private UserService userService;
    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private MediaService mediaService;
    @Inject
    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    private ActorService actorService;
    @Inject
    public void setActorService(ActorService actorService) {
        this.actorService = actorService;
    }

    private ReviewService reviewService;
    @Inject
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    private MainService mainService;
    @Inject
    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    private View view;
    @Inject
    public void setView(View view) {
        log.info("setView");
        this.view = view;
    }

    @Inject
    private List<Media> mediaList;

    @Inject
    private List<Actor> actorList;

    @Inject
    private List<Review> reviewList;

    @Inject
    private List<User> userList;

    private void launch() {

        FillMocksToDB();

        log.info("launch");
        User user = createUser();
        do{
            view.printMedias(mediaService.findAll());
            long selectedMediaId = selectMediaId();
            mainService.doReview(user.getName(),user.getPassword(), selectedMediaId,view.getReviewTextFromConsole(),view.getRatingFromConsole());
        }while (view.anotherReviewFromConsole());

        view.printMedias(mediaService.findAll());
        long selectedMediaId = selectMediaId();
        averageReviews(selectedMediaId);
    }

    private void FillMocksToDB() {
        actorService.saveAll(actorList);
        mediaService.saveAll(mediaList);
        userService.saveAll(userList);
        reviewService.saveAll(reviewList);
    }

    private User createUser(){
        view.printRegistration();
        log.info("createUser");
        User user = this.view.readUserData();
        userService.saveUser(user);
        view.printWelcomeMessage(user);
        return user;
    }

    private long selectMediaId(){
        log.info("selectMedia");
        return view.getIdFromConsole();
    }

    private void averageReviews(long selected){
        log.info("averageReviews");
        view.averageReviewsToConsole(mediaService.getAverageRating(selected));
    }

    public static void main(String[] args) {
        try(ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)){
            AppSpring app = appContext.getBean(AppSpring.class);
            app.launch();
        }
    }
}
