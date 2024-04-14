package com.demo.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
@ActiveProfiles(profiles = "test")
class AppServiceTest {

    @Autowired
    AppService service;
    @MockBean
    TestService testService;


    @Test
    void getStudent() {

        when(testService.getString()).thenReturn("testing");
        stubFor(get(urlEqualTo("/student"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                    "id": 34,
                                    "name": "test"
                                }
                                """)));
        stubFor(get(urlEqualTo("/account"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                    "id": 34,
                                    "name": "test"
                                }
                                """)));

        var result= service.getStudent();
        assertEquals(34, result.getId());
        assertEquals("testing", result.getName());

    }


}