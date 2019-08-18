package com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository;

import com.codeclan.dinopark.DinoPark.models.Dinosaur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DinosaurRepository extends JpaRepository<Dinosaur, Long>, DinosaurRepositoryCustom {

//    List<Dinosaur> findDinosaurByPaddockId(Long id);
}
