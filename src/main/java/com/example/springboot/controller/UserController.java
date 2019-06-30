package com.example.springboot.controller;

import com.example.springboot.UserLoginToken;
import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepository;

    @UserLoginToken
    @GetMapping("/user/{id}")//get user via id
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    @UserLoginToken
    @GetMapping("/user/getUser")
    public User getUserByEmail(String email){
        User user = userRepository.findByEmail(email).get(0);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

    @UserLoginToken
    @GetMapping("/users")
    public List getUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/user/login")
    public User login(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Map<String , Object>map){
        User targetUser = userRepository.findByEmail(email).get(0);
        if (!targetUser.getPassword().equals(password)){
            System.out.println(targetUser.getPassword());
            return null;
        }
        String token = targetUser.getNewToken(targetUser);
        targetUser.setToken(token);
        return targetUser;

    }
}
