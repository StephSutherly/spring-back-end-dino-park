package com.codeclan.dinopark.DinoPark.controllers;

import com.codeclan.dinopark.DinoPark.models.Carnivore;
import com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository.CarnivoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/carnivores")
public class CarnivoreController {

  @Autowired
  CarnivoreRepository carnivoreRepository;

  @GetMapping
  public List<Carnivore> getAllCarnivores() {
    return carnivoreRepository.findAll();
  }

  @PostMapping
  public void addNewCarnivore(@RequestBody Carnivore carnivore) {
    carnivoreRepository.save(carnivore);
  }

  @GetMapping(value = "/{id}")
  public Optional<Carnivore> findCarnivore(@PathVariable Long id) {
    return carnivoreRepository.findById(id);
  }

  @PutMapping(value = "/{id}")
  public void updateCarnivore(@PathVariable Long id, @RequestBody Carnivore carnivore) {
    if(findCarnivore(id).get() != null) {
      carnivoreRepository.save(carnivore);
    }
  }

  @DeleteMapping(value = "/{id}")
  public void deleteCarnivore(@PathVariable Long id) {
    carnivoreRepository.delete(findCarnivore(id).get());
  }

  @GetMapping(value = "/hunger")
  public void findAllCarnivoresAndDecreaseFullnessLevel() {
    List<Carnivore> carnivores = getAllCarnivores();
    for (Carnivore carnivore : carnivores) {
      carnivore.decreaseFullnessLevel(20);
      carnivoreRepository.save(carnivore);
    }
  }
}
