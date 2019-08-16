package com.codeclan.dinopark.DinoPark.models;

import javax.persistence.*;

@Entity
@Table(name="paddocks")
public class Paddock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="is_herbivore")
  private boolean isHerbivore;

  public Paddock(boolean isHerbivore) {
    this.isHerbivore = isHerbivore;
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
}
