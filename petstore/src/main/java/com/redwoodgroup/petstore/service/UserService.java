package com.redwoodgroup.petstore.service;
import com.redwoodgroup.petstore.dbModels.UserEntity;
import com.redwoodgroup.petstore.dto.ApiResponce;
import com.redwoodgroup.petstore.dto.User;
import com.redwoodgroup.petstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

private List<User> users = new ArrayList<>();

    public ApiResponce createUser (User user){
    ApiResponce responce = new ApiResponce();
        users.add(user);
    try {
        UserEntity userentity = new UserEntity();
        userentity.setUsername(user.getUsername());
        userentity.setFirstName(user.getFirstName());
        userentity.setLastName(user.getLastName());
        userentity.setEmail(user.getEmail());
        userentity.setUserStatus(user.getUserStatus());
        userentity.setPassword(user.getPassword());
        userentity.setPhone(user.getPhone());
        userRepository.save(userentity);
            responce.setCode(200);
            responce.setMessage("created user successfully");
    }catch(Exception e){
        responce.setCode(402);
        responce.setMessage("Something went wrong");
        }

    return responce;

}
public ApiResponce createUserWithList(List<User> user){
    ApiResponce responce = new ApiResponce();
    List<UserEntity> userinfo = new ArrayList<>();
    User usr = new User();
    try {
        for (int i = 0; i < user.size(); i++) {
            usr = user.get(i);
            UserEntity entity = new UserEntity();
            entity.setUsername(usr.getUsername());
            entity.setFirstName(usr.getFirstName());
            entity.setLastName(usr.getLastName());
            entity.setEmail(usr.getEmail());
            entity.setUserStatus(usr.getUserStatus());
            entity.setPassword(usr.getPassword());
            entity.setPhone(usr.getPhone());
            userinfo.add(entity);
            userRepository.saveAll(userinfo);
        }

        responce.setCode(200);
        responce.setMessage("User added successfully");
    }catch (Exception e){
        responce.setCode(404);
        responce.setMessage("Users not Found");
    }


    return responce;

}
public User getUser(String username){
    User user = new User();
    UserEntity userEntity = userRepository.findByUsername(username);
    user.setUsername(userEntity.getUsername());
    user.setFirstName(userEntity.getFirstName());
    user.setLastName(userEntity.getLastName());
    user.setPassword(userEntity.getPassword());
    user.setPhone(userEntity.getPhone());
    user.setEmail(userEntity.getEmail());
    user.setUserStatus(userEntity.getUserStatus());
    return user;
    }


    public ApiResponce updateUser(String username, User user){

        ApiResponce response = new ApiResponce();
        UserEntity userEntity = userRepository.findByUsername(username);

        try {
            if (user.getFirstName().equalsIgnoreCase("string")){
                String fn = userEntity.getFirstName();
                userEntity.setFirstName(fn);
            }
            else {
                userEntity.setFirstName(user.getFirstName());
            }


            if (user.getLastName().equalsIgnoreCase("string")){
                String ln = userEntity.getLastName();
                userEntity.setLastName(ln);
            }
            else {
                userEntity.setLastName(user.getLastName());
            }

            if (user.getPassword().equalsIgnoreCase("string")){
                String psw = userEntity.getPassword();
                userEntity.setPassword(psw);
            }
            else {
                userEntity.setPassword(user.getPassword());
            }

            if (user.getPhone().equalsIgnoreCase("string")){
                String phn = userEntity.getPhone();
                userEntity.setPhone(phn);
            }
            else {
                userEntity.setPhone(user.getPhone());
            }

            if (user.getEmail().equalsIgnoreCase("string")){
                String eml = userEntity.getEmail();
                userEntity.setEmail(eml);
            }
            else {
                userEntity.setEmail(user.getEmail());
            }

            if (user.getUserStatus()==0){
                int us = userEntity.getUserStatus();
                userEntity.setUserStatus(us);
            }
            else {
                userEntity.setUserStatus(user.getUserStatus());
            }

            userEntity.setId(userEntity.getId());
            userRepository.save(userEntity);

            response.setCode(200);
            response.setMessage("updated user successfully");
        }catch (Exception e){
            response.setCode(404);
            response.setMessage("username not found");
        }



        return response;
    }

    public ApiResponce deleteUser(String username){
        ApiResponce response = new ApiResponce();
        try {
            UserEntity userEntity = userRepository.deleteByUsername(username);
            userRepository.delete(userEntity);
            response.setCode(200);
            response.setMessage("deleted user successfully");
        }catch (Exception e){
            response.setCode(404);
            response.setMessage("username not found");
        }

        return response;
    }

}
