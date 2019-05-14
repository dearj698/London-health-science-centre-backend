package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")//get user via id
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping(value = "/user/login")
    public String login(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Map<String , Object>map){
        User targetUser = userRepository.findByEmail(email).get(0);
        if (!targetUser.getPassword().equals(password)){
            System.out.println(targetUser.getPassword());
            return "false";
        }
        return "true";

    }
}
