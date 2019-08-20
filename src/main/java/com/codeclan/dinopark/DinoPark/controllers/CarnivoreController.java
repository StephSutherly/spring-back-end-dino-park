package com.codeclan.dinopark.DinoPark.controllers;

import com.codeclan.dinopark.DinoPark.models.Carnivore;
import com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository.CarnivoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carnivores")
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

  @GetMapping(value="/{id}")
  public Optional<Carnivore> findCarnivore(@PathVariable Long id) {
    return carnivoreRepository.findById(id);
  }
}
