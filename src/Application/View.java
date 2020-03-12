package Application;

import Model.Builders.ReviewBuilder;
import Model.Builders.UserBuilder;
import Model.Media;
import Model.Rating;
import Model.Review;
import Model.User;
import jdk.jshell.spi.ExecutionControl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner  in;

    public View() {
        in = new Scanner(System.in);
    }

    public User readUserData()  {
        UserBuilder userBuilder = new UserBuilder();

        System.out.println("What is your name?");
        userBuilder.setName(in.nextLine());

        System.out.println("Type your e-mail address:");
        userBuilder.setEmail(in.nextLine());

        System.out.println("Type a new password:");
        userBuilder.setPassword(in.nextLine());

        return userBuilder.getUser();
    }

    public void printWelcomeMessage(User user){
        System.out.println(String.format("Welcome to the jungle " + user.getName() + "!"));
    }

    public void printMedias(List<Media> medias){
        for (int i = 0; i < medias.size(); i++){
            System.out.println(i+": "+medias.get(i));
        }
        System.out.println("Choose an id:");
    }

    public Media selectMedia(List<Media> medias){
        String input = in.nextLine();
        int inputNumber = Integer.parseInt(input);
        int i =-1;
        for(Media m : medias){
            if(++i==inputNumber){
                return m;
            }
        }
        return null;
    }

    public Review writeReview(){
        ReviewBuilder reviewBuilder = new ReviewBuilder();

        System.out.println("Write review:");
        reviewBuilder.setText(in.nextLine());

        System.out.println("Choose a rating! (BAD, AVERAGE, GOOD)");
        Rating rate=Rating.GOOD;
        switch (in.nextLine().toLowerCase()){
            case "bad" :
                rate=Rating.BAD;
                break;
            case "average":
                rate=Rating.AVERAGE;
                break;
            case "good":
                rate=Rating.GOOD;
                break;
        }
        reviewBuilder.setRating(rate);
        return reviewBuilder.getReview();
    }

    public void printReviews(Media selectedMedia){
        double sum = selectedMedia.getReviews().stream().mapToInt(o->o.getRating().rate).sum();
        double num = selectedMedia.getReviews().stream().count();
        double average = sum/num;
        System.out.println("Average of reviews: " + average);
    }

    public boolean questionYesOrNo(String message) {
        while (true){
            System.out.println(message + " [yes/no]");
            switch (in.nextLine()) {
                case "yes":
                    return true;
                case "no":
                    return false;
            }
        }
    }
}
