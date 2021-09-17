package com.redwoodgroup.petstore.service;

import com.redwoodgroup.petstore.dbModels.VisitEntity;
import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.dto.Visit;
import com.redwoodgroup.petstore.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;

    public ApiResponce createVisit(Visit visit){
        VisitEntity visitEntity = new VisitEntity();
        ApiResponce responce = new ApiResponce();
        try {
            visitEntity.setDescription(visit.getDescription());
            visitRepository.save(visitEntity);
            responce.setCode(200);
            responce.setMessage("Visit created Successfully");
        }catch (Exception e){
            responce.setCode(404);
            responce.setMessage("Something went wrong");
        }
        return responce;
    }

}
