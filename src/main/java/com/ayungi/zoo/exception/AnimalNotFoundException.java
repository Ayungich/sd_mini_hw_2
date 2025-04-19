package com.ayungi.zoo.exception;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long id) {
        super("Животное с id=" + id + " не найдено");
    }
}
