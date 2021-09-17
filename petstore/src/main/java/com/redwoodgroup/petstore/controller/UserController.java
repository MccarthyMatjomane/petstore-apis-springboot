package com.redwoodgroup.petstore.controller;


import com.redwoodgroup.petstore.dto.User;
import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/User/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user/create",method = RequestMethod.POST)
    @ResponseBody
    public ApiResponce createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }
    //****************************
    @RequestMapping(value = "/user/createWithList",method = RequestMethod.POST)
    @ResponseBody
    public ApiResponce createUserWithList(@Valid @RequestBody List<User> userInfo){
        return userService.createUserWithList(userInfo);
    }
    //********************************

    //********************************

    @RequestMapping(value = "/user/{username}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("username") String username){
        return userService.getUser(username);
    }
    //***********************
  @PutMapping(value = "/user/{username}")
    @ResponseBody
    public ApiResponce updateUser(@PathVariable("username") String username,User user){
        return userService.updateUser(username,user);
    }

    //*********************
    @DeleteMapping(value = "/user/{username}")
    @ResponseBody
    public ApiResponce deleteUser(@PathVariable("username") String username){
        return userService.deleteUser(username);
    }

}
