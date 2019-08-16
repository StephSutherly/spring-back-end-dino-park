package com.codeclan.dinopark.DinoPark.repositories;

import com.codeclan.dinopark.DinoPark.models.Paddock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PaddockRepository extends JpaRepository<Paddock, Long> {
//  List<Paddock> findPaddocksWithDinosaursNamed(String name);
}
