package com.codeclan.dinopark.DinoPark.models;

public class Carnivore extends Dinosaur {

    private CarnivoreType type;

    public Carnivore(String name, boolean isCarnivore, int fullnessLevel, CarnivoreType type) {
        super(name, isCarnivore, fullnessLevel);
        this.type = type;
    }

    public CarnivoreType getType() {
        return type;
    }

    public void setType(CarnivoreType type) {
        this.type = type;
    }
}
