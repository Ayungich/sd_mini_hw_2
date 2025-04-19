package com.ayungi.zoo.presentation;

import com.ayungi.zoo.application.service.EnclosureService;
import com.ayungi.zoo.domain.Enclosure;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enclosures")
public class EnclosureController {

    private final EnclosureService service;

    public EnclosureController(EnclosureService service) { this.service = service; }

    @GetMapping public List<Enclosure> list() { return service.list(); }

    @PostMapping public Enclosure add(@RequestBody Enclosure e) { return service.add(e); }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }

    @PostMapping("/{id}/clean") public void clean(@PathVariable Long id) { service.clean(id); }
}
