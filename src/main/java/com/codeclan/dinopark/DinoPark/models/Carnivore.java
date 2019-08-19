package com.codeclan.dinopark.DinoPark.models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Carnivore")
public class Carnivore extends Dinosaur {

    @Column(name="type")
    @Enumerated(value = EnumType.STRING)
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
