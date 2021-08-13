package com.redwoodgroup.petstore.service;

import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
@Service
public class UserService {
private List<User> users = new ArrayList<>();
public ApiResponce createUser (User user){
    ApiResponce responce = new ApiResponce();
    if(user.getEmail().contains("@")){
        users.add(user);
        responce.setCode(200);
        responce.setMessage("created user successfully");
    }
    else{
        responce.setCode(200);
        responce.setMessage("Please enter correct Email Address");
    }
    return responce;

}
public ApiResponce createUserWithList(ArrayList userList){
    User user = new User();
    userList.add(user);
    ApiResponce responce = new ApiResponce();
    responce.setCode(200);
    responce.setMessage("User added successfully");
    return responce;

}
public User getUser(String username){
    User user = new User();
    ApiResponce responce = new ApiResponce();
    int userIndex=-1;
    for (User usr: users){
        if (usr.getUsername().equalsIgnoreCase(username)){
            userIndex = users.indexOf(usr);
            break;
        }
    }
        if (userIndex != -1){
            user = users.get(userIndex);
            responce.setCode(200);
            responce.setMessage("User successfully retrieved");
        }
        else {
            responce.setCode(404);
            responce.setMessage("User not Found");
        }
    return  user;
    }


    public ApiResponce updateUser(String username, User user){
        ApiResponce response = new ApiResponce();
        int index = -1;
        for (User usr: users){
            if (usr.getUsername().equalsIgnoreCase(username)){
                index = users.indexOf(usr);
                break;
            }
        }
        if (index != -1) {
            users.set(index, user);
            response.setCode(200);
            response.setMessage("updated user successfully");
        }
        else {
            response.setCode(404);
            response.setMessage("username not found");
        }

        return response;
    }

    public ApiResponce deleteUser(String username){
        ApiResponce response = new ApiResponce();
        int index = -1;
        for (User usr: users){
            if (usr.getUsername().equalsIgnoreCase(username)){
                index = users.indexOf(usr);
                break;
            }
        }
        if (index != -1) {
            users.remove(index);
            response.setCode(200);
            response.setMessage("deleted user successfully");
        }
        else {
            response.setCode(404);
            response.setMessage("username not found");
        }

        return response;
    }

}
