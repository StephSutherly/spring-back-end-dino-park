package com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository;

import com.codeclan.dinopark.DinoPark.models.Herbivore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HerbivoreRepository extends JpaRepository<Herbivore, Long> {
}
