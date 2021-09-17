package com.redwoodgroup.petstore.service;

import com.redwoodgroup.petstore.dbModels.TypeEntity;
import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.dto.Types;
import com.redwoodgroup.petstore.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public ApiResponce createType(Types types){
        TypeEntity typeEntity = new TypeEntity();
        ApiResponce response = new ApiResponce();
        try {
            typeEntity.setName(types.getName());
            typeRepository.save(typeEntity);

            response.setCode(200);
            response.setMessage("Type created successfully");
        }catch (Exception e){
            response.setCode(404);
            response.setMessage("Something went wrong");
        }
        return response;
    }

    public ApiResponce deleteType(String name){
        TypeEntity typeEntity = new TypeEntity();
        ApiResponce response = new ApiResponce();
        typeEntity = typeRepository.deleteByName(name);
        try {
            typeRepository.delete(typeEntity);
            response.setCode(200);
            response.setMessage("Type deleted successfully");
        }catch (Exception e){
            response.setCode(404);
            response.setMessage("Type was not Found");
        }
        return response;
    }
}
