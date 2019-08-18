package com.codeclan.dinopark.DinoPark.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name="dino_diet")
@Table(name="dinosaurs")

public abstract class Dinosaur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="is_herbivore")
    private boolean isHerbivore;

    @Column(name="fullness_level")
    private int fullnessLevel;

    @JsonIgnoreProperties("dinosaurs")
    @ManyToOne
    @JoinColumn(name = "paddock_id", nullable = false)
    private Paddock paddock;


    public Dinosaur(String name, boolean isHerbivore, int fullnessLevel, Paddock paddock) {
        this.name = name;
        this.isHerbivore = isHerbivore;
        this.fullnessLevel = fullnessLevel;
        this.paddock = paddock;
    }

    public Dinosaur() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHerbivore() {
        return isHerbivore;
    }

    public void setHerbivore(boolean herbivore) {
        isHerbivore = herbivore;
    }

    public int getFullnessLevel() {
        return fullnessLevel;
    }

    public void setFullnessLevel(int fullnessLevel) {
        this.fullnessLevel = fullnessLevel;
    }

    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }
}
