package com.courseplat.courseplat.controllers;
import com.courseplat.courseplat.domain.user.User;
import com.courseplat.courseplat.domain.user.UserRecordDto;
import com.courseplat.courseplat.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
   private com.courseplat.courseplat.domain.user.UserRepository UserRepository;




    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(UserRepository.findById(id).get());
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(UserRepository.findAll());
    }



}
