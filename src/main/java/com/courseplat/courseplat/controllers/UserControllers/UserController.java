package com.courseplat.courseplat.controllers.UserControllers;
import com.courseplat.courseplat.domain.user.User;
import com.courseplat.courseplat.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
   private com.courseplat.courseplat.domain.user.UserRepository UserRepository;




    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(UserRepository.findById(id).get());
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(UserRepository.findAll());
    }



}
