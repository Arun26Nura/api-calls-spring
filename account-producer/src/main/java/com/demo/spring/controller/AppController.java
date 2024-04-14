package com.demo.spring.controller;

import com.demo.spring.dto.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("account")
    ResponseEntity<Account> getStudent(){
        return ResponseEntity.ok(new Account(1,"arun"));
    }
}
