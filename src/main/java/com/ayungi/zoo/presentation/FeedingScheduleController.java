package com.ayungi.zoo.presentation;

import com.ayungi.zoo.application.service.FeedingService;
import com.ayungi.zoo.domain.FeedingSchedule;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/feedings")
public class FeedingScheduleController {

    private final FeedingService service;

    public FeedingScheduleController(FeedingService service) { this.service = service; }

    @GetMapping public List<FeedingSchedule> list() { return service.list(); }

    @PostMapping public FeedingSchedule add(@RequestBody FeedingSchedule s) { return service.create(s); }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }

    @PostMapping("/{id}/execute") public void execute(@PathVariable Long id) { service.markExecuted(id); }
}
