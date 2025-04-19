package com.ayungi.zoo.infrastructure.repository;

import com.ayungi.zoo.domain.Enclosure;
import java.util.List;

public interface EnclosureRepository {
    Enclosure save(Enclosure enclosure);
    Enclosure findById(Long id);
    List<Enclosure> findAll();
    void deleteById(Long id);
}
