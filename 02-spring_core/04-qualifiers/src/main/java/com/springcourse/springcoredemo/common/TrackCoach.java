package com.springcourse.springcoredemo.common;

import com.springcourse.springcoredemo.util.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run a Had 5k!";
    }
}
