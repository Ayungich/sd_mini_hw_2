package com.ayungi.zoo.exception;

public class EnclosureNotFoundException extends RuntimeException {
    public EnclosureNotFoundException(Long id) {
        super("Вольер с id=" + id + " не найден");
    }
}
