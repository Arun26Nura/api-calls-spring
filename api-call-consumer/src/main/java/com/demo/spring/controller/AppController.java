package com.demo.spring.controller;

import com.demo.spring.dto.Student;
import com.demo.spring.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private final AppService service;

    AppController(AppService service){
        this.service=service;
    }

    @GetMapping("api/test")
    ResponseEntity<Student> getStudent(){
        return ResponseEntity.ok(service.getStudent());
    }
}
