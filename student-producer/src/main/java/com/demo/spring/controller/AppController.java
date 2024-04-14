package com.demo.spring.controller;

import com.demo.spring.dto.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("student")
    ResponseEntity<Student> getStudent(){
        return ResponseEntity.ok(new Student(1,"arun"));
    }
}
