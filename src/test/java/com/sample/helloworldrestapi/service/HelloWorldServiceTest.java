package com.sample.helloworldrestapi.service;

import static org.junit.jupiter.api.Assertions.*;

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
        String message = service.helloWorld("Alice");
        assertEquals("Hello Alice", message);
    }

    @Test
    void invalidNameTest() {
        String message = service.helloWorld("Tara");
        assertEquals("", message);
    }

    @Test
    void emptyNameTest() {
        String message = service.helloWorld("");
        assertEquals("", message);
    }

    @Test
    void nameWithWhiteSpacesTest() {
        String message = service.helloWorld(" Alice");
        assertEquals("", message);
    }
}