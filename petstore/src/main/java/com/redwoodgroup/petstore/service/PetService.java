package com.redwoodgroup.petstore.service;

import com.redwoodgroup.petstore.dbModels.PetEntity;
import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.dto.Pet;
import com.redwoodgroup.petstore.dto.PetWithoutDate;
import com.redwoodgroup.petstore.repository.PetReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PetService {
    @Autowired
   private PetReposotory petReposotory;
    public ApiResponce createPet(Pet pet){
        ApiResponce response = new ApiResponce();
        try {
            PetEntity petEntity = new PetEntity();
            petEntity.setName(pet.getName());
            petEntity.setStatus(pet.getStatus());
            petEntity.setBirthDate(Timestamp.valueOf(pet.getDateOfBirth()));
            petReposotory.save(petEntity);
            response.setCode(404);
            response.setMessage("Pet created successfully");

        }catch (Exception e){
            response.setCode(404);
            response.setMessage("Something went wrong");
        }
        return response;
    }

    public ApiResponce updatePet(String name, PetWithoutDate petWithoutDate){
        PetEntity petEntity = petReposotory.findByname(name);
        ApiResponce response = new ApiResponce();
        try {
            petEntity.setStatus(petWithoutDate.getStatus());
            petEntity.setName(petWithoutDate.getName());
            petEntity.setCreatedAt(petEntity.getCreatedAt());
            petEntity.setId(petEntity.getId());
            petEntity.setBirthDate(petEntity.getBirthDate());
            petReposotory.save(petEntity);
            response.setCode(200);
            response.setMessage("Pet updated successfully");
        }catch (Exception e){
            response.setCode(404);
            response.setMessage("The pet was not found");
        }
        return response;
    }


    public ApiResponce deletePet(String name){
        ApiResponce responce = new ApiResponce();
        try {
            PetEntity petEntity = petReposotory.findByname(name);
            petReposotory.delete(petEntity);
            responce.setCode(200);
            responce.setMessage("Pet deleted");
        }catch (Exception e){
            responce.setCode(404);
            responce.setMessage("Pet not found");
        }

        return responce;
    }

}
