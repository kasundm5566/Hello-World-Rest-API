package com.sample.helloworldrestapi.service;

import static org.junit.jupiter.api.Assertions.*;

import com.sample.helloworldrestapi.model.HelloWorldSuccessResponse;
import com.sample.helloworldrestapi.service.impl.HelloWorldServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldServiceTest {

    @Autowired
    private HelloWorldServiceImpl service;

    @Test
    void validNameTest() {
        HelloWorldSuccessResponse response = service.helloWorld("Alice");
        assertEquals("Hello Alice", response.getMessage());
    }

    @Test
    void invalidNameTest() {
        HelloWorldSuccessResponse response = service.helloWorld("Tara");
        assertEquals("", response.getMessage());
    }

    @Test
    void emptyNameTest() {
        HelloWorldSuccessResponse response = service.helloWorld("");
        assertEquals("", response.getMessage());
    }

    @Test
    void nameWithWhiteSpacesTest() {
        HelloWorldSuccessResponse response = service.helloWorld(" Alice");
        assertEquals("", response.getMessage());
    }
}