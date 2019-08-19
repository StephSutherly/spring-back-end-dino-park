package com.codeclan.dinopark.DinoPark.models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Herbivore")
public class Herbivore extends Dinosaur {

    @Column(name="type")
    @Enumerated(value = EnumType.STRING)
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
