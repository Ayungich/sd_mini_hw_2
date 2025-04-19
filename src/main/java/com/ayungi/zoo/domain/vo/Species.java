package com.ayungi.zoo.domain.vo;

public record Species(String latinName) {
    public Species {
        if (latinName == null || latinName.isBlank()) {
            throw new IllegalArgumentException("Species name must not be blank");
        }
    }
}
