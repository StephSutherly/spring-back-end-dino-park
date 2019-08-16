package com.codeclan.dinopark.DinoPark.repositories;

import com.codeclan.dinopark.DinoPark.models.Dinosaur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinosaurRepository extends JpaRepository<Dinosaur, Long> {
}
