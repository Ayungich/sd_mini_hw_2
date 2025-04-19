package com.ayungi.zoo.application.service;

import com.ayungi.zoo.application.port.out.AnimalRepository;
import com.ayungi.zoo.domain.Animal;
import com.ayungi.zoo.domain.events.AnimalMovedEvent;
import com.ayungi.zoo.exception.AnimalNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepo;
    private final EnclosureService enclosureService;

    public AnimalService(AnimalRepository animalRepo, EnclosureService enclosureService) {
        this.animalRepo = animalRepo;
        this.enclosureService = enclosureService;
    }

    public Animal add(Animal a) { return animalRepo.save(a); }

    public void delete(Long id) {
        ensureExists(id);
        animalRepo.delete(id);
    }

    public List<Animal> list() { return animalRepo.findAll(); }

    public void feed(Long id) {
        Animal a = ensureExists(id);
        a.feed();
        animalRepo.save(a);
    }

    public void heal(Long id) {
        Animal a = ensureExists(id);
        a.treat();
        animalRepo.save(a);
    }

    public AnimalMovedEvent transfer(Long animalId, Long toEnclosureId) {
        Animal animal = ensureExists(animalId);
        return enclosureService.transferAnimal(animal, toEnclosureId);
    }

    private Animal ensureExists(Long id) {
        Animal a = animalRepo.findById(id);
        if (a == null) throw new AnimalNotFoundException(id);
        return a;
    }
}
