package com.codeclan.dinopark.DinoPark.components;

import com.codeclan.dinopark.DinoPark.models.*;
import com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository.DinosaurRepository;
import com.codeclan.dinopark.DinoPark.repositories.paddock_repository.PaddockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DinosaurRepository dinosaurRepository;

    @Autowired
    PaddockRepository paddockRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Paddock paddockGreen = new Paddock("Hammond", true);
        paddockRepository.save(paddockGreen);

        Paddock paddockBlue = new Paddock("Grant", true);
        paddockRepository.save(paddockBlue);

        Paddock paddockOrange = new Paddock("Malcolm", true);
        paddockRepository.save(paddockOrange);

        Paddock paddockRed = new Paddock("Muldoon", false);
        paddockRepository.save(paddockRed);

        Paddock paddockYellow = new Paddock("Arnold", false);
        paddockRepository.save(paddockYellow);

        Paddock paddockPurple = new Paddock("Nedry", false);
        paddockRepository.save(paddockPurple);

        Herbivore herbivore1 = new Herbivore("Archie", true,100, HerbivoreType.ATOPODENTATUS, paddockGreen);
        dinosaurRepository.save(herbivore1);

        Herbivore herbivore2 = new Herbivore("Tricia", true,100, HerbivoreType.TRICERATOPS, paddockGreen);
        dinosaurRepository.save(herbivore2);

        Herbivore herbivore3 = new Herbivore("Stelios", true,100, HerbivoreType.STEGOSAURUS, paddockGreen);
        dinosaurRepository.save(herbivore3);

        Herbivore herbivore4 = new Herbivore("Cendy", true,80, HerbivoreType.CENTROSAURUS, paddockGreen);
        dinosaurRepository.save(herbivore4);

        Carnivore carnivore1 = new Carnivore("Mossom", false,50, CarnivoreType.MOSOSAURUS, paddockRed);
        dinosaurRepository.save(carnivore1);

        Carnivore carnivore2 = new Carnivore("Valerie", false,50, CarnivoreType.VELOCIRAPTOR, paddockYellow);
        dinosaurRepository.save(carnivore2);

        }
    }
