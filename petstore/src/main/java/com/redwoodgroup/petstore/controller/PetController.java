package com.redwoodgroup.petstore.controller;

import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.dto.Pet;
import com.redwoodgroup.petstore.dto.PetWithoutDate;
import com.redwoodgroup.petstore.dto.User;
import com.redwoodgroup.petstore.service.PetService;
import com.redwoodgroup.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/Pet/")
public class PetController {
    @Autowired
    private PetService petService;
    @RequestMapping(value = "/pet/create",method = RequestMethod.POST)
    @ResponseBody
    public ApiResponce createPet(@Valid @RequestBody Pet pet){
        return petService.createPet(pet);
    }
//*******************************

    @PutMapping(value = "/pet/{name}")
    @ResponseBody
    public ApiResponce updatePet(@PathVariable("name") String name, PetWithoutDate pet){
        return petService.updatePet(name,pet);
    }
    //******************************
    @DeleteMapping(value = "/pet/{name}")
    @ResponseBody
    public ApiResponce deletePet(@PathVariable("name") String name){
        return petService.deletePet(name);
    }

}
