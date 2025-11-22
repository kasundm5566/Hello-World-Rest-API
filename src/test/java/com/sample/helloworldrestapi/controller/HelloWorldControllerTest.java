package com.sample.helloworldrestapi.controller;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sample.helloworldrestapi.exception.InvalidNameException;
import com.sample.helloworldrestapi.model.HelloWorldSuccessResponse;
import com.sample.helloworldrestapi.service.HelloWorldService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class HelloWorldControllerTest {

    private HelloWorldService service;
    private HelloWorldController controller;

    @BeforeEach
    void setUp() {
        service = mock(HelloWorldService.class);
        controller = new HelloWorldController(service);
    }

    @Test
    void validNameTest() {
        when(service.helloWorld("Alice"))
                .thenReturn("Hello Alice");

        ResponseEntity<Object> response = controller.helloWorld("Alice");

        assertThat(response.getStatusCode().value()).isEqualTo(200);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertInstanceOf(HelloWorldSuccessResponse.class, response.getBody());
        assertThat(((HelloWorldSuccessResponse) response.getBody()).getMessage()).isEqualTo("Hello Alice");
    }

    @Test
    void invalidNameTest() {
        when(service.helloWorld("Tara"))
                .thenReturn("");

        try {
            controller.helloWorld("Tara");
        } catch (InvalidNameException ex) {
            assertThat(ex.getMessage()).isEqualTo("Invalid Input");
        }
    }

    @Test
    void emptyNameTest() {
        when(service.helloWorld(""))
                .thenReturn("");

        try {
            controller.helloWorld("");
        } catch (InvalidNameException ex) {
            assertThat(ex.getMessage()).isEqualTo("Invalid Input");
        }
    }

    @Test
    void nameWithWhiteSpacesTest() {
        when(service.helloWorld(" Alice"))
                .thenReturn("");

        try {
            controller.helloWorld(" Alice");
        } catch (InvalidNameException ex) {
            assertThat(ex.getMessage()).isEqualTo("Invalid Input");
        }
    }
}
