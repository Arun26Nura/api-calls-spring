package com.demo.spring.service;

import com.demo.spring.dto.Account;
import com.demo.spring.dto.Student;
import com.demo.spring.util.AccountClient;
import com.demo.spring.util.StudentClient;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private final TestService testService;
    private final StudentClient studentClient;
    private final AccountClient accountClient;

    AppService(StudentClient studentClient,AccountClient accountClient, TestService testService ){
        this.studentClient=studentClient;
        this.testService=testService;
        this.accountClient=accountClient;
    }

    public Student getStudent() {
        String name=testService.getString();

        Student student= studentClient.getStudent().getBody();
        Account account= accountClient.getAccount().getBody();

        student.setName(name);
        return student;
    }
}
