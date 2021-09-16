package com.redwoodgroup.petstore.repository;

import com.redwoodgroup.petstore.dbModels.PetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetReposotory extends CrudRepository<PetEntity,Integer> {
    PetEntity findByname(String name);
}
