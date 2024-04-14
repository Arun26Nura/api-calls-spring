package com.demo.spring.util;

import com.demo.spring.dto.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentClient {

    private final WebClient studentWebClient;

    public StudentClient(WebClient studentWebClient) {
        this.studentWebClient=studentWebClient;
    }


    public Student getStudent() {


        return studentWebClient.get()
                .uri("/student")
                .retrieve()
                .bodyToMono(Student.class)
                .block();



    }
}
