package com.ayungi.zoo.presentation;

import com.ayungi.zoo.application.service.ZooStatisticsService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class ZooStatisticsController {

    private final ZooStatisticsService stats;

    public ZooStatisticsController(ZooStatisticsService stats) { this.stats = stats; }

    @GetMapping public Map<String, Object> get() { return stats.getStatistics(); }
}
