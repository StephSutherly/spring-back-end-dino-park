package com.codeclan.dinopark.DinoPark.controllers;

import com.codeclan.dinopark.DinoPark.models.Dinosaur;
import com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository.DinosaurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/dinosaurs")
public class DinosaurController {

    @Autowired
    DinosaurRepository dinosaurRepository;

    @GetMapping
    public List<Dinosaur> getAllDinosaurs() {
        return dinosaurRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public Optional<Dinosaur> findDinosaur(@PathVariable Long id) {
        return dinosaurRepository.findById(id);
    }

    @GetMapping(value = "/paddock/{id}")
    public List<Dinosaur> findDinosaurByPaddock(@PathVariable Long id) {
        return dinosaurRepository.findDinosaurByPaddockId(id);
    }

    @GetMapping(value = "/feed")
    public void findAllDinosaursAndUpdateFullnessLevel() {
        List<Dinosaur> dinosaurs = getAllDinosaurs();
        for (Dinosaur dinosaur : dinosaurs) {
            dinosaur.setFullnessLevel(100);
            dinosaurRepository.save(dinosaur);
        }
    }

}
