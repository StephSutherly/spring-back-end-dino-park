package com.codeclan.dinopark.DinoPark.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="paddocks")
public class Paddock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="is_herbivore")
  private boolean isHerbivore;


  @OneToMany(mappedBy = "paddock", fetch = FetchType.LAZY)

  private List<Dinosaur> dinosaurs;

  public Paddock(boolean isHerbivore) {
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
