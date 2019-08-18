package com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository;

import com.codeclan.dinopark.DinoPark.models.Dinosaur;

import java.util.List;

public interface DinosaurRepositoryCustom {
    List <Dinosaur> findDinosaurByPaddockId(Long id);
}
