package com.codeclan.dinopark.DinoPark.controllers;

import com.codeclan.dinopark.DinoPark.models.Dinosaur;
import com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository.DinosaurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dinosaurs")
public class DinosaurController {

    @Autowired
    DinosaurRepository dinosaurRepository;

    @GetMapping
    public List<Dinosaur> getAllDinosaurs() {
        return dinosaurRepository.findAll();
    }

    @GetMapping(value = "/paddock/{paddock}")
    public List<Dinosaur> findDinosaurByPaddock(@PathVariable Long id) {
     return dinosaurRepository.findDinosaurByPaddockId(id);
    }

}
