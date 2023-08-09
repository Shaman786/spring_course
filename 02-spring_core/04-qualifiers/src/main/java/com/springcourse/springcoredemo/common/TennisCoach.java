package com.springcourse.springcoredemo.common;

import com.springcourse.springcoredemo.util.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
