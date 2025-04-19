package com.ayungi.zoo.infrastructure.repository;

import com.ayungi.zoo.application.port.out.FeedingScheduleRepository;
import com.ayungi.zoo.domain.FeedingSchedule;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryFeedingScheduleRepository implements FeedingScheduleRepository {

    private final Map<Long, FeedingSchedule> storage = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public FeedingSchedule save(FeedingSchedule s) {
        if (s.getId() == null) {
            s.setId(seq.getAndIncrement());
        }
        storage.put(s.getId(), s);
        return s;
    }

    @Override
    public FeedingSchedule findById(Long id) {
        return storage.get(id);
    }

    @Override
    public List<FeedingSchedule> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }
}
