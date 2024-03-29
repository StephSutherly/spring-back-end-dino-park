package com.codeclan.dinopark.DinoPark.controllers;

import com.codeclan.dinopark.DinoPark.models.Paddock;
import com.codeclan.dinopark.DinoPark.repositories.paddock_repository.PaddockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/paddocks")
public class PaddockController {

  @Autowired
  PaddockRepository paddockRepository;

  @GetMapping
  public List<Paddock> findAllPaddocks() {
    return paddockRepository.findAll();
  }

  @PostMapping
  public void addNewPaddock(@RequestBody Paddock paddock) {
    paddockRepository.save(paddock);
  }

  @GetMapping(value = "/{id}")
  public Optional<Paddock> findPaddock(@PathVariable Long id) {
    return paddockRepository.findById(id);
  }

  @PutMapping(value = "/{id}")
  public void updatePaddock(@PathVariable Long id, @RequestBody Paddock paddock) {
    if(findPaddock(id).get() != null) {
      paddockRepository.save(paddock);
    }
  }

  @GetMapping(value = "/dinosaurs/named/{name}")
  public List<Paddock> findPaddocksWithDinosaursNamed(@PathVariable String name) {
    return paddockRepository.findPaddocksWithDinosaursNamed(name);
  }

  @GetMapping(value = "/herbivores")
  public List<Paddock> findPaddocksByIsHerbivoresTrue() {
    return paddockRepository.findPaddocksByIsHerbivore(true);
  }

  @GetMapping(value = "/carnivores")
  public List<Paddock> findPaddocksByIsHerbivoresFalse() {
    return paddockRepository.findPaddocksByIsHerbivore(false);
  }
}
