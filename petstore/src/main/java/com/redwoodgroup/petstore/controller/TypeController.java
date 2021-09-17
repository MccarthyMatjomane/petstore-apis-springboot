package com.redwoodgroup.petstore.controller;

import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.dto.Types;
import com.redwoodgroup.petstore.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/Type/")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/type/create",method = RequestMethod.POST)
    @ResponseBody
    public ApiResponce createType(@Valid @RequestBody Types types){
        return typeService.createType(types);
    }


    @DeleteMapping(value = "/type/{name}")
    @ResponseBody
    public ApiResponce deleteType(@PathVariable("name") String name){
        return typeService.deleteType(name);
    }

}
