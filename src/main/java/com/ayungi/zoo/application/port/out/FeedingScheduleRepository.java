package com.ayungi.zoo.application.port.out;

import com.ayungi.zoo.domain.FeedingSchedule;
import java.util.List;

public interface FeedingScheduleRepository {
    FeedingSchedule save(FeedingSchedule schedule);
    FeedingSchedule findById(Long id);
    List<FeedingSchedule> findAll();
    void delete(Long id);
}
