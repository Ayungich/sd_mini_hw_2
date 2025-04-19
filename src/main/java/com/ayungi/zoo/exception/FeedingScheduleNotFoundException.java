package com.ayungi.zoo.exception;

public class FeedingScheduleNotFoundException extends RuntimeException {
    public FeedingScheduleNotFoundException(Long id) {
        super("Расписание кормления с id=" + id + " не найдено");
    }
}
