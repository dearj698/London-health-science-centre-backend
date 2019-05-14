package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.entity.UserCase;
import com.example.springboot.repository.UserCaseRepository;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class UserCaseController {
    @Autowired
    UserCaseRepository userCaseRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/bookcase")
    public UserCase bookCase( UserCase userCase){
       User user = this.userRepository.findByEmail(userCase.getEmail()).get(0);
       user.addCase(userCase);
       UserCase usercase = userCaseRepository.save(userCase);
       return usercase;
    }
}

