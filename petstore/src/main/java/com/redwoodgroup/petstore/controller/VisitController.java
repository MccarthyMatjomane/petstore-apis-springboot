package com.redwoodgroup.petstore.controller;

import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.dto.Visit;
import com.redwoodgroup.petstore.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/visit/")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @RequestMapping(value = "/visit/create",method = RequestMethod.POST)
    @ResponseBody
    public ApiResponce createVisit(@Valid @RequestBody Visit visit){
        return visitService.createVisit(visit);
    }

}
