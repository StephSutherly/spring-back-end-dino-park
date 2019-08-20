package com.codeclan.dinopark.DinoPark.controllers;

import com.codeclan.dinopark.DinoPark.models.Herbivore;
import com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository.HerbivoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/herbivores")
public class HerbivoreController {

  @Autowired
  HerbivoreRepository herbivoreRepository;

  @GetMapping
  public List<Herbivore> getAllHerbivores() {
    return herbivoreRepository.findAll();
  }

  @PostMapping
  public void addNewHerbivore(@RequestBody Herbivore herbivore) {
    herbivoreRepository.save(herbivore);
  }

  @GetMapping(value="/{id}")
  public Optional<Herbivore> findHerbivore(@PathVariable Long id) {
    return herbivoreRepository.findById(id);
  }

  @PutMapping(value="/{id}")
  public void updateHerbivore(@PathVariable Long id, @RequestBody Herbivore herbivore) {
    if(findHerbivore(id).get() != null) {
      herbivoreRepository.save(herbivore);
    }
  }

  @DeleteMapping(value="/{id}")
  public void deleteHerbivore(@PathVariable Long id) {
    herbivoreRepository.delete(findHerbivore(id).get());
  }
}
