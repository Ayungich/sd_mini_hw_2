package com.ayungi.zoo.presentation;

import com.ayungi.zoo.application.service.AnimalService;
import com.ayungi.zoo.domain.Animal;
import com.ayungi.zoo.domain.events.AnimalMovedEvent;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) { this.service = service; }

    @GetMapping public List<Animal> getAll() { return service.list(); }

    @PostMapping public Animal add(@RequestBody Animal animal) { return service.add(animal); }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }

    @PostMapping("/{id}/feed") public void feed(@PathVariable Long id) { service.feed(id); }

    @PostMapping("/{id}/heal") public void heal(@PathVariable Long id) { service.heal(id); }

    @PostMapping("/{id}/transfer")
    public AnimalMovedEvent transfer(@PathVariable Long id, @RequestParam Long toEnclosureId) {
        return service.transfer(id, toEnclosureId);
    }
}
