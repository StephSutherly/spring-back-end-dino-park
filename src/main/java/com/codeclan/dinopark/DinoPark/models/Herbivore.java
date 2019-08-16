package com.codeclan.dinopark.DinoPark.models;

public class Herbivore extends Dinosaur {

    private HerbivoreType type;

    public Herbivore(String name, boolean isHerbivore, int fullnessLevel, HerbivoreType type, Paddock paddock) {
        super(name, isHerbivore, fullnessLevel, paddock);
        this.type = type;
    }

    public HerbivoreType getType() {
        return type;
    }

    public void setType(HerbivoreType type) {
        this.type = type;
    }
}
