package com.example.bmdb.builders;


import com.example.bmdb.data.Actor;
import com.example.bmdb.data.Media;
import com.example.bmdb.data.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActorBuilder {

    private String name;
    private LocalDate born;
    private String biography;
    private Sex sex;
    private List<Media> filmography;

    public ActorBuilder() {
        this.filmography = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public String getBiography() {
        return biography;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Media> getFilmography() {
        return filmography;
    }

    public ActorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ActorBuilder setBorn(LocalDate born) {
        this.born = born;
        return this;
    }

    public ActorBuilder setBiography(String biography) {
        this.biography = biography;
        return this;
    }

    public ActorBuilder setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public ActorBuilder setFilmography(List<Media> filmography) {
        this.filmography = filmography;
        return this;
    }

    public Actor getActor(){
        return new Actor(this);
    }
}
