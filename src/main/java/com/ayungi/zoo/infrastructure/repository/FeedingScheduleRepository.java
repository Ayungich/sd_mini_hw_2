package com.ayungi.zoo.infrastructure.repository;

import com.ayungi.zoo.domain.FeedingSchedule;
import java.util.List;

public interface FeedingScheduleRepository {
    FeedingSchedule save(FeedingSchedule schedule);
    FeedingSchedule findById(Long id);
    List<FeedingSchedule> findAll();
    void deleteById(Long id);
}
