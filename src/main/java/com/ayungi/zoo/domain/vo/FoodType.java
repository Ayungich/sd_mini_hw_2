package com.ayungi.zoo.domain.vo;

public record FoodType(String value) {
    public FoodType {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Food type must not be blank");
        }
    }
}
