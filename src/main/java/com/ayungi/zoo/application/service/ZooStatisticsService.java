package com.ayungi.zoo.application.service;

import com.ayungi.zoo.application.port.out.AnimalRepository;
import com.ayungi.zoo.application.port.out.EnclosureRepository;
import com.ayungi.zoo.domain.Animal;
import com.ayungi.zoo.domain.Enclosure;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ZooStatisticsService {

    private final AnimalRepository animalRepo;
    private final EnclosureRepository enclosureRepo;

    public ZooStatisticsService(AnimalRepository animalRepo, EnclosureRepository enclosureRepo) {
        this.animalRepo = animalRepo;
        this.enclosureRepo = enclosureRepo;
    }

    public Map<String, Object> getStatistics() {
        List<Animal> animals = animalRepo.findAll();
        List<Enclosure> enclosures = enclosureRepo.findAll();
        long totalAnimals = animals.size();
        long freeEnclosures = enclosures.stream()
                .filter(e -> e.getCurrentAnimalCount() < e.getMaxCapacity())
                .count();
        return Map.of("totalAnimals", totalAnimals, "freeEnclosures", freeEnclosures);
    }
}
