package com.ayungi.zoo.application.service;

import com.ayungi.zoo.application.port.out.FeedingScheduleRepository;
import com.ayungi.zoo.domain.FeedingSchedule;
import com.ayungi.zoo.domain.events.FeedingTimeEvent;
import com.ayungi.zoo.exception.FeedingScheduleNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedingService {

    private final FeedingScheduleRepository repo;

    public FeedingService(FeedingScheduleRepository repo) {
        this.repo = repo;
    }

    public FeedingSchedule create(FeedingSchedule s) { return repo.save(s); }

    public List<FeedingSchedule> list() { return repo.findAll(); }

    public void delete(Long id) { repo.delete(id); }

    public FeedingTimeEvent markExecuted(Long id) {
        FeedingSchedule s = repo.findById(id);
        if (s == null) throw new FeedingScheduleNotFoundException(id);
        s.markFeedingAsExecuted();
        repo.save(s);
        return new FeedingTimeEvent(s.getAnimalId(), s.getFeedingTime());
    }
}
