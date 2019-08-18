package com.codeclan.dinopark.DinoPark.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Herbivore")
public class Herbivore extends Dinosaur {

    private HerbivoreType type;

    public Herbivore(String name, boolean isHerbivore, int fullnessLevel, HerbivoreType type, Paddock paddock) {
        super(name, isHerbivore, fullnessLevel, paddock);
        this.type = type;
    }

    public Herbivore() {

    }

    public HerbivoreType getType() {
        return type;
    }

    public void setType(HerbivoreType type) {
        this.type = type;
    }
}
