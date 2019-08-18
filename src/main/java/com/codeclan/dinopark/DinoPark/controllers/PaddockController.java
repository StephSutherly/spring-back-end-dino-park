package com.codeclan.dinopark.DinoPark.controllers;

import com.codeclan.dinopark.DinoPark.models.Paddock;
import com.codeclan.dinopark.DinoPark.repositories.paddock_repository.PaddockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/paddocks")
public class PaddockController {

  @Autowired
  PaddockRepository paddockRepository;

  @GetMapping
  public List<Paddock> findAllPaddocks() {
    return paddockRepository.findAll();
  }

  @GetMapping("{id}")
  public Optional<Paddock> findPaddock(@PathVariable Long id) {
    return paddockRepository.findById(id);
  }

  @GetMapping(value="/dinosaurs/named/{name}")
  public List<Paddock> findPaddocksWithDinosaursNamed(@PathVariable String name) {
    return paddockRepository.findPaddocksWithDinosaursNamed(name);
  }
}
