package com.codeclan.dinopark.DinoPark.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="paddocks")
public class Paddock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column(name="is_herbivore")
  private boolean isHerbivore;

  @JsonIgnoreProperties("paddock")
  @OneToMany(mappedBy = "paddock", fetch = FetchType.LAZY)
  private List<Dinosaur> dinosaurs;

  public Paddock(String name, boolean isHerbivore) {
    this.name = name;
    this.isHerbivore = isHerbivore;
    this.dinosaurs = new ArrayList<>();
  }

  public Paddock() {

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

  public List<Dinosaur> getDinosaurs() {
    return dinosaurs;
  }

  public void setDinosaurs(List<Dinosaur> dinosaurs) {
    this.dinosaurs = dinosaurs;
  }

  public void addDinosaur(Dinosaur dinosaur) {
    this.dinosaurs.add(dinosaur);
  }
}
