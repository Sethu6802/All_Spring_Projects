package com.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.db.service.MyUserDetailService;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserController {

    Logger logger = Logger.getLogger("UserController.class");

    @Autowired
    MyUserDetailService service;


    @GetMapping(value = "/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetails> getByName(@PathVariable String username) {

    	UserDetails optional = service.loadUserByUsername(username);
        return ResponseEntity.status(200).body(optional);
    }


}