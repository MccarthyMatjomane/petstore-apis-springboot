package com.redwoodgroup.petstore.repository;

import com.redwoodgroup.petstore.dbModels.VisitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<VisitEntity,Integer> {

}
