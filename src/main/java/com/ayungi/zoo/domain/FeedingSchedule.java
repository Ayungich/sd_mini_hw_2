package com.ayungi.zoo.domain;

import com.ayungi.zoo.domain.vo.FoodType;
import java.time.LocalDateTime;

public class FeedingSchedule {
    private Long id;
    private Long animalId;
    private LocalDateTime feedingTime;
    private FoodType foodType;
    private boolean executed;

    public FeedingSchedule() { }

    public FeedingSchedule(Long id, Long animalId, LocalDateTime feedingTime, FoodType foodType) {
        this.id = id;
        this.animalId = animalId;
        this.feedingTime = feedingTime;
        this.foodType = foodType;
        this.executed = false;
    }

    public void changeSchedule(LocalDateTime newTime, FoodType newFood) {
        this.feedingTime = newTime;
        this.foodType = newFood;
    }

    public void markFeedingAsExecuted() {
        this.executed = true;
    }

    /* getters & setters */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAnimalId() { return animalId; }
    public void setAnimalId(Long animalId) { this.animalId = animalId; }

    public LocalDateTime getFeedingTime() { return feedingTime; }
    public void setFeedingTime(LocalDateTime feedingTime) { this.feedingTime = feedingTime; }

    public FoodType getFoodType() { return foodType; }
    public void setFoodType(FoodType foodType) { this.foodType = foodType; }

    public boolean isExecuted() { return executed; }
    public void setExecuted(boolean executed) { this.executed = executed; }
}
