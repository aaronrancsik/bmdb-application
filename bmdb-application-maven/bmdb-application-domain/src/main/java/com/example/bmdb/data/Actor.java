package com.example.bmdb.data;


import com.example.bmdb.builders.ActorBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Actor {
    private String name;
    private LocalDate born;
    private String biography;
    private Sex sex;
    private List<Media> filmography;

    public Actor(ActorBuilder actorBuilder) {
        this.name = actorBuilder.getName();
        this.born = actorBuilder.getBorn();
        this.biography=actorBuilder.getBiography();
        this.sex=actorBuilder.getSex();
        this.filmography = actorBuilder.getFilmography();
    }

    public Actor(String name, LocalDate born, String biography, Sex sex, List<Media> filmography) {
        this.name = name;
        this.born = born;
        this.biography = biography;
        this.sex = sex;
        this.filmography = filmography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Media> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<Media> filmography) {
        this.filmography = filmography;
        for (Media m : filmography){
            m.addCast(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) &&
                Objects.equals(born, actor.born) &&
                Objects.equals(biography, actor.biography) &&
                sex == actor.sex &&
                Objects.equals(filmography, actor.filmography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, born, biography, sex, filmography);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", born=" + born +
                ", biography='" + biography + '\'' +
                ", sex=" + sex +
                '}';
    }
}
