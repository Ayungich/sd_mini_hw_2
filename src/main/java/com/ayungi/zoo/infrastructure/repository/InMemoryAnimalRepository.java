package com.ayungi.zoo.infrastructure.repository;

import com.ayungi.zoo.application.port.out.AnimalRepository;
import com.ayungi.zoo.domain.Animal;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryAnimalRepository implements AnimalRepository {

    private final Map<Long, Animal> storage = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public Animal save(Animal a) {
        if (a.getId() == null) {
            a.setId(seq.getAndIncrement());
        }
        storage.put(a.getId(), a);
        return a;
    }

    @Override
    public Animal findById(Long id) {
        return storage.get(id);
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }
}
