package com.ayungi.zoo.application.service;

import com.ayungi.zoo.application.port.out.AnimalRepository;
import com.ayungi.zoo.application.port.out.EnclosureRepository;
import com.ayungi.zoo.domain.Animal;
import com.ayungi.zoo.domain.Enclosure;
import com.ayungi.zoo.domain.events.AnimalMovedEvent;
import com.ayungi.zoo.exception.EnclosureCapacityExceededException;
import com.ayungi.zoo.exception.EnclosureNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnclosureService {

    private final EnclosureRepository encRepo;
    private final AnimalRepository animalRepo;

    public EnclosureService(EnclosureRepository encRepo, AnimalRepository animalRepo) {
        this.encRepo = encRepo;
        this.animalRepo = animalRepo;
    }

    public Enclosure add(Enclosure e) { return encRepo.save(e); }
    public void delete(Long id) { encRepo.delete(id); }
    public List<Enclosure> list() { return encRepo.findAll(); }

    public void clean(Long id) {
        Enclosure e = ensureExists(id);
        e.clean();
        encRepo.save(e);
    }

    public AnimalMovedEvent transferAnimal(Animal animal, Long toId) {
        Enclosure to = ensureExists(toId);
        Long fromId = animal.getEnclosureId();
        Enclosure from = fromId != null ? ensureExists(fromId) : null;

        if (!to.addAnimal(animal.getId()))
            throw new EnclosureCapacityExceededException(toId);

        if (from != null) from.removeAnimal(animal.getId());
        animal.move(toId);

        encRepo.save(to);
        if (from != null) encRepo.save(from);
        animalRepo.save(animal);

        return new AnimalMovedEvent(animal.getId(), fromId, toId);
    }

    private Enclosure ensureExists(Long id) {
        Enclosure e = encRepo.findById(id);
        if (e == null) throw new EnclosureNotFoundException(id);
        return e;
    }
}
