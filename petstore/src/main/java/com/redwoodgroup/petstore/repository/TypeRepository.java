package com.redwoodgroup.petstore.repository;

import com.redwoodgroup.petstore.dbModels.TypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<TypeEntity,Integer> {
    TypeEntity deleteByName(String name);

}
