package com.ayungi.zoo.infrastructure.repository;

import com.ayungi.zoo.application.port.out.EnclosureRepository;
import com.ayungi.zoo.domain.Enclosure;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryEnclosureRepository implements EnclosureRepository {

    private final Map<Long, Enclosure> storage = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public Enclosure save(Enclosure e) {
        if (e.getId() == null) {
            e.setId(seq.getAndIncrement());
        }
        storage.put(e.getId(), e);
        return e;
    }

    @Override
    public Enclosure findById(Long id) {
        return storage.get(id);
    }

    @Override
    public List<Enclosure> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }
}
