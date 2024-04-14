package com.demo.spring.util;

import com.demo.spring.dto.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class StudentClient {

    private final RestClient studentRestClient;

    public StudentClient(RestClient studentRestClient) {
        this.studentRestClient=studentRestClient;
    }


    public Student getStudent() {


        Student student= studentRestClient.get()
                .uri("/student")
                .retrieve()
                .body(Student.class);


        return student;
    }
}
