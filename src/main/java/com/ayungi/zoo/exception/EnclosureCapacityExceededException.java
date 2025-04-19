package com.ayungi.zoo.exception;

public class EnclosureCapacityExceededException extends RuntimeException {
    public EnclosureCapacityExceededException(Long id) {
        super("Вольер id=" + id + " заполнен — превышена вместимость");
    }
}
