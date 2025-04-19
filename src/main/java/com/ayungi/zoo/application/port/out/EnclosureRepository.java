package com.ayungi.zoo.application.port.out;

import com.ayungi.zoo.domain.Enclosure;
import java.util.List;

public interface EnclosureRepository {
    Enclosure save(Enclosure enclosure);
    Enclosure findById(Long id);
    List<Enclosure> findAll();
    void delete(Long id);
}
