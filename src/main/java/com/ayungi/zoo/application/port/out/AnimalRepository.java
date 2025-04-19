package com.ayungi.zoo.application.port.out;

import com.ayungi.zoo.domain.Animal;

import java.util.List;

public interface AnimalRepository {
    Animal save(Animal animal);
    Animal findById(Long id);
    List<Animal> findAll();
    void delete(Long id);
}
