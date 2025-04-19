package com.ayungi.zoo.domain;

import com.ayungi.zoo.domain.vo.*;
import java.time.LocalDate;

public class Animal {

    public enum AnimalStatus { HEALTHY, SICK }

    private Long id;
    private Species species;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private FoodType favoriteFood;
    private AnimalStatus status;
    private Long enclosureId;

    public Animal() { }

    public Animal(Long id,
                  Species species,
                  String name,
                  LocalDate birthDate,
                  Gender gender,
                  FoodType favoriteFood,
                  AnimalStatus status,
                  Long enclosureId) {
        this.id = id;
        this.species = species;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.favoriteFood = favoriteFood;
        this.status = status;
        this.enclosureId = enclosureId;
    }

    public void feed() {
        System.out.println("Feeding animal " + name);
    }

    public void treat() {
        this.status = AnimalStatus.HEALTHY;
    }

    public void move(Long newEnclosureId) {
        this.enclosureId = newEnclosureId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public FoodType getFavoriteFood() { return favoriteFood; }
    public void setFavoriteFood(FoodType favoriteFood) { this.favoriteFood = favoriteFood; }

    public AnimalStatus getStatus() { return status; }
    public void setStatus(AnimalStatus status) { this.status = status; }

    public Long getEnclosureId() { return enclosureId; }
    public void setEnclosureId(Long enclosureId) { this.enclosureId = enclosureId; }
}
