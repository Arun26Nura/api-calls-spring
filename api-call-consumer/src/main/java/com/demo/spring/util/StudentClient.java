package com.demo.spring.util;

import com.demo.spring.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "student-producer", url = "${app.inventory.student-base-url}")
public interface StudentClient {

    @RequestMapping(method = RequestMethod.GET, value = "/student")
    ResponseEntity<Student> getStudent();
}
