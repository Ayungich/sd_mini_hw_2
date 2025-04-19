package com.ayungi.zoo.domain;

import com.ayungi.zoo.domain.vo.Size;
import java.util.HashSet;
import java.util.Set;

public class Enclosure {
    private Long id;
    private String type; // predator, herbivore, etc.
    private Size size;
    private int maxCapacity;
    private Set<Long> animalIds = new HashSet<>();

    public Enclosure() { }

    public Enclosure(Long id, String type, Size size, int maxCapacity) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.maxCapacity = maxCapacity;
    }

    /* Business logic */
    public boolean addAnimal(Long animalId) {
        if (animalIds.size() >= maxCapacity) return false;
        return animalIds.add(animalId);
    }

    public boolean removeAnimal(Long animalId) {
        return animalIds.remove(animalId);
    }

    public void clean() {
        System.out.println("Cleaning enclosure " + id);
    }

    /* getters & setters */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Size getSize() { return size; }
    public void setSize(Size size) { this.size = size; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    public int getCurrentAnimalCount() { return animalIds.size(); }
    public Set<Long> getAnimalIds() { return animalIds; }
}
