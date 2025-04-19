package com.ayungi.zoo.domain.events;

import java.time.LocalDateTime;

public class AnimalMovedEvent {
    private final Long animalId;
    private final Long fromEnclosureId;
    private final Long toEnclosureId;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public AnimalMovedEvent(Long animalId, Long fromEnclosureId, Long toEnclosureId) {
        this.animalId = animalId;
        this.fromEnclosureId = fromEnclosureId;
        this.toEnclosureId = toEnclosureId;
    }

    public Long getAnimalId() { return animalId; }
    public Long getFromEnclosureId() { return fromEnclosureId; }
    public Long getToEnclosureId() { return toEnclosureId; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
