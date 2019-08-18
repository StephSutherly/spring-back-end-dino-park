package com.codeclan.dinopark.DinoPark.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Carnivore")
public class Carnivore extends Dinosaur {

    private CarnivoreType type;

    public Carnivore(String name, boolean isHerbivore, int fullnessLevel, CarnivoreType type, Paddock paddock) {
        super(name, isHerbivore, fullnessLevel, paddock);
        this.type = type;
    }

    public Carnivore() {
        
    }

    public CarnivoreType getType() {
        return type;
    }

    public void setType(CarnivoreType type) {
        this.type = type;
    }
}
