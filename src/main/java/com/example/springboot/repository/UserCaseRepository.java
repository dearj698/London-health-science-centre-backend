package com.example.springboot.repository;

import com.example.springboot.entity.User;
import com.example.springboot.entity.UserCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserCaseRepository extends JpaRepository<UserCase, Integer> {
}

