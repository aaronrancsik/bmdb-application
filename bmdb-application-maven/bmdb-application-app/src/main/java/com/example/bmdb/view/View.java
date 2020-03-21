package com.example.bmdb.view;


import com.example.bmdb.builders.ReviewBuilder;
import com.example.bmdb.builders.UserBuilder;
import com.example.bmdb.data.Media;
import com.example.bmdb.data.Rating;
import com.example.bmdb.data.Review;
import com.example.bmdb.data.User;
import org.springframework.stereotype.Component;


import javax.inject.Inject;
import java.util.List;
import java.util.Scanner;

@Component
public class View {

    private Scanner in;

    I18nMsg i18nMsg;
    @Inject
    public void setI18nMsg(I18nMsg i18nMsg) {
        this.i18nMsg = i18nMsg;
    }

    UserBuilder userBuilder;
    @Inject
    public void setUserBuilder(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    ReviewBuilder reviewBuilder;
    @Inject
    public void setReviewBuilder(ReviewBuilder reviewBuilder) {
        this.reviewBuilder = reviewBuilder;
    }

    public View() {
        in = new Scanner(System.in);
    }

    public User readUserData()  {

        System.out.println(i18nMsg.getMsg("view.question.name"));
        userBuilder.setName(in.nextLine());

        System.out.println(i18nMsg.getMsg("view.get.email"));
        userBuilder.setEmail(in.nextLine());

        System.out.println(i18nMsg.getMsg("view.get.newPassword"));
        userBuilder.setPassword(in.nextLine());

        return userBuilder.getUser();
    }

    public void printWelcomeMessage(User user){
        System.out.println(i18nMsg.getMsg("view.welcome",new Object[]{ user.getName() }));
    }

    public void printMedias(List<Media> medias){
        System.out.println(i18nMsg.getMsg("view.medias"));
        for (int i = 0; i < medias.size(); i++){
            System.out.println(i+": "+medias.get(i));
        }
        System.out.println(i18nMsg.getMsg("view.get.id"));
    }

    public int getMediaNumberFromConsole(){
        String input = in.nextLine();
        int inputNumber = Integer.parseInt(input);
        return inputNumber;
    }

    public Review getReviewFromConsole(){
        reviewBuilder.setText(getReviewTextFromConsole());
        reviewBuilder.setRating(getRatingFromConsole());
        return reviewBuilder.getReview();
    }

    private String getReviewTextFromConsole() {
        System.out.println(i18nMsg.getMsg("view.get.review"));
        return in.nextLine();
    }

    private Rating getRatingFromConsole() {
        Rating rate = null;
        while (rate == null){
            System.out.println(i18nMsg.getMsg("view.get.rating"));
            String choosedRate = in.nextLine().toLowerCase();
            if(choosedRate.equals(i18nMsg.getMsg("view.rate.bad"))) {
                rate=Rating.BAD;
            }
            else if(choosedRate.equals(i18nMsg.getMsg("view.rate.average"))){
                rate=Rating.AVERAGE;
            }
            else if(choosedRate.equals(i18nMsg.getMsg("view.rate.good"))){
                rate=Rating.GOOD;
            }
        }
        return rate;
    }

    public void averageReviewsToConsole(double average){
        System.out.println(i18nMsg.getMsg("view.averageReview", average));
    }

    public boolean anotherReviewFromConsole() {
        while (true){
            System.out.println(i18nMsg.getMsg("view.question.anotherReview"));
            String yesOrNo = in.nextLine();
            if(yesOrNo.equals(i18nMsg.getMsg("view.yes"))){
                return true;
            }else if(yesOrNo.equals(i18nMsg.getMsg("view.no"))){
                return false;
            }
        }
    }
}
