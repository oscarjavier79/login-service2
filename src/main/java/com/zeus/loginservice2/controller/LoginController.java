package com.zeus.loginservice2.controller;

import com.zeus.loginservice2.repository.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @PostMapping(value = "/login",  produces = "application/json")
    public ResponseEntity<String> login(@RequestBody User   user){


        return  new ResponseEntity<String>("", HttpStatus.OK);
    }
}
