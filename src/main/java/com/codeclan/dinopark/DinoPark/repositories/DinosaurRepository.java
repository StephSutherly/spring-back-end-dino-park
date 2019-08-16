package com.codeclan.dinopark.DinoPark.repositories;

import com.codeclan.dinopark.DinoPark.models.Dinosaur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DinosaurRepository extends JpaRepository<Dinosaur, Long> {
}
