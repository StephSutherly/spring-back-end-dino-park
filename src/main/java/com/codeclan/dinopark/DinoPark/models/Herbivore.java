package com.codeclan.dinopark.DinoPark.models;

public class Herbivore extends Dinosaur {

    private HerbivoreType type;

    public Herbivore(String name, boolean isHerbivore, int fullnessLevel, HerbivoreType type) {
        super(name, isHerbivore, fullnessLevel);
        this.type = type;
    }

    public HerbivoreType getType() {
        return type;
    }

    public void setType(HerbivoreType type) {
        this.type = type;
    }
}
