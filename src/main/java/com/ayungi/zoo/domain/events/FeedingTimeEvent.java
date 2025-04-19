package com.ayungi.zoo.domain.events;

import java.time.LocalDateTime;

public class FeedingTimeEvent {
    private final Long animalId;
    private final LocalDateTime feedingTime;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public FeedingTimeEvent(Long animalId, LocalDateTime feedingTime) {
        this.animalId = animalId;
        this.feedingTime = feedingTime;
    }

    public Long getAnimalId() { return animalId; }
    public LocalDateTime getFeedingTime() { return feedingTime; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
