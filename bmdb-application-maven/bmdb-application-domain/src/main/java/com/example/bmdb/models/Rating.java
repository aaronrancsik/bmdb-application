package com.example.bmdb.models;

import java.util.HashMap;
import java.util.Map;


public enum Rating {
    BAD(1), AVERAGE(3), GOOD(5);

    public final int rate;
    private Rating(int rate) {
        this.rate=rate;
    }
    private static final Map<com.example.bmdb.models.Rating, Integer> BY_RATE=new HashMap<>();
    static{
        for(com.example.bmdb.models.Rating r: values()){
            BY_RATE.put(r, r.rate);
        }
    }
    public static int valueOfRating(com.example.bmdb.models.Rating rating){
        return BY_RATE.get(rating);
    }
}