package com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository;

import com.codeclan.dinopark.DinoPark.models.Dinosaur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DinosaurRepository extends JpaRepository<Dinosaur, Long>, DinosaurRepositoryCustom {

//    List<Dinosaur> findDinosaurByPaddockId(Long id);
}
