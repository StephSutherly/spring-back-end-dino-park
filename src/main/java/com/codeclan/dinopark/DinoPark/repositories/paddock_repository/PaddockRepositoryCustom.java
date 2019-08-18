package com.codeclan.dinopark.DinoPark.repositories.paddock_repository;

import com.codeclan.dinopark.DinoPark.models.Paddock;

import java.util.List;

public interface PaddockRepositoryCustom {
  List<Paddock> findPaddocksWithDinosaursNamed(String name);
}
