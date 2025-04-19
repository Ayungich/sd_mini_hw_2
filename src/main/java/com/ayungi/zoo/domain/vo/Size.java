package com.ayungi.zoo.domain.vo;

public record Size(double squareMeters) {
    public Size {
        if (squareMeters <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
    }
}
