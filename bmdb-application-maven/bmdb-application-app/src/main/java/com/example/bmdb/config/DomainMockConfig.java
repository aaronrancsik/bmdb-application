package com.example.bmdb.config;

import com.example.bmdb.builders.ActorBuilder;
import com.example.bmdb.builders.MediaBuilder;
import com.example.bmdb.builders.ReviewBuilder;
import com.example.bmdb.builders.UserBuilder;
import com.example.bmdb.data.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DomainMockConfig {

    @Bean
    public Actor createActor0(){
        return new ActorBuilder()
                .setName("Actor 1")
                .setBorn(LocalDate.of(1910, 1, 11))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 1").getActor();
    }

    @Bean
    public Actor createActor1(){
        return new ActorBuilder()
                .setName("Actor 2")
                .setBorn(LocalDate.of(1920, 2, 12))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 2")
                .getActor();
    }

    @Bean
    public Actor createActor2(){
        return new ActorBuilder()
                .setName("Actor 3")
                .setBorn(LocalDate.of(1930, 3, 13))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 3")
                .getActor();
    }

    @Bean
    public Actor createActor3(){
        return new ActorBuilder()
                .setName("Actor 4")
                .setBorn(LocalDate.of(1940, 4, 14))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 4")
                .getActor();
    }

    @Bean
    public Actor createActor4(){
        return new ActorBuilder()
                .setName("Actor 5")
                .setBorn(LocalDate.of(1950, 5, 15))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 5")
                .getActor();
    }

    @Bean
    public Actor createActor5(){
        return new ActorBuilder()
                .setName("Actor 6")
                .setBorn(LocalDate.of(1960, 6, 16))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 6")
                .getActor();
    }

    @Bean
    public Actor createActor6(){
        return new ActorBuilder()
                .setName("Actor 7")
                .setBorn(LocalDate.of(1970, 7, 17))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 7")
                .getActor();
    }
    @Bean
    public Actor createActor7(){
        return new ActorBuilder()
                .setName("Actor 8")
                .setBorn(LocalDate.of(1980, 8, 18))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 8")
                .getActor();
    }
    @Bean
    public Actor createActor8(){
        return new ActorBuilder()
                .setName("Actor 9")
                .setBorn(LocalDate.of(1990, 9, 19))
                .setSex(Sex.MALE)
                .setBiography("Bio Bullshit 9")
                .getActor();
    }

    @Bean
    public Actor createActor9(){
        return new ActorBuilder()
                .setName("Actor 10")
                .setBorn(LocalDate.of(2000, 10, 20))
                .setSex(Sex.FEMALE)
                .setBiography("Bio Bullshit 10")
                .getActor();
    }

    @Bean
    public Media createMedia0(){
        return new MediaBuilder()
                .setId(BigDecimal.valueOf(1))
                .setTitle("Movie 1")
                .setDescription("Super description 1")
                .setPremier(LocalDate.of(2011, 1, 20))
                .addCast(createActor0())
                .addCast(createActor1())
                .getSeries();
    }

    @Bean
    public Media createMedia1(){
        return new MediaBuilder()
                .setId(BigDecimal.valueOf(2))
                .setTitle("Movie 1")
                .setDescription("Super description 1")
                .setPremier(LocalDate.of(2011, 1, 20))
                .addCast(createActor2())
                .addCast(createActor3())
                .getSeries();
    }

    @Bean
    public Media createMedia2(){
        return new MediaBuilder()
                .setId(BigDecimal.valueOf(3))
                .setTitle("Movie 3")
                .setDescription("Super description 3")
                .setPremier(LocalDate.of(2013, 3, 23))
                .addCast(createActor4())
                .addCast(createActor5())
                .getSeries();
    }

    @Bean
    public Media createMedia3(){
        return new MediaBuilder()
                .setId(BigDecimal.valueOf(4))
                .setTitle("Movie 4")
                .setDescription("Super description 4")
                .setPremier(LocalDate.of(2014, 4, 24))
                .addCast(createActor6())
                .addCast(createActor7())
                .getSeries();
    }

    @Bean
    public Media createMedia4(){
        return new MediaBuilder()
                .setId(BigDecimal.valueOf(5))
                .setTitle("Movie 5")
                .setDescription("Super description 5")
                .setPremier(LocalDate.of(2015, 5, 15))
                .addCast(createActor8())
                .addCast(createActor9())
                .getSeries();
    }

    @Bean
    public User createUser0() {
        return new UserBuilder()
                .setName("Alma")
                .setEmail("alma@ealma.com")
                .setPassword("batman")
                .getUser();
    }

    @Bean
    public User createUser1() {
        return new UserBuilder()
                .setName("Banana")
                .setEmail("banan@banan.com")
                .setPassword("beethoven")
                .getUser();
    }

    @Bean
    public User createUser2() {
        return new UserBuilder()
                .setName("Peel")
                .setEmail("peel@peel.com")
                .setPassword("brown")
                .getUser();
    }

    @Bean
    public Review createReview0(){
        return new ReviewBuilder()
                .setText("rev 1")
                .setCreator(createUser0())
                .setMedia(createMedia0())
                .setRating(Rating.GOOD)
                .getReview();
    }


    @Bean
    public Review createReview1(){
        return new ReviewBuilder()
                .setText("rev 2")
                .setCreator(createUser0())
                .setMedia(createMedia1())
                .setRating(Rating.BAD)
                .getReview();
    }

    @Bean
    public Review createReview2(){
        return new ReviewBuilder()
                .setText("rev 3")
                .setCreator(createUser1())
                .setMedia(createMedia2())
                .setRating(Rating.AVERAGE)
                .getReview();
    }

    @Bean
    public Review createReview3(){
        return new ReviewBuilder()
                .setText("rev 4")
                .setCreator(createUser1())
                .setMedia(createMedia3())
                .setRating(Rating.GOOD)
                .getReview();
    }

    @Bean
    public Review createReview4(){
        return new ReviewBuilder()
                .setText("rev 5")
                .setCreator(createUser2())
                .setMedia(createMedia4())
                .setRating(Rating.BAD)
                .getReview();
    }

    @Bean
    public Review createReview5(){
        return new ReviewBuilder()
                .setText("rev 6")
                .setCreator(createUser2())
                .setMedia(createMedia4())
                .setRating(Rating.AVERAGE)
                .getReview();
    }


}
