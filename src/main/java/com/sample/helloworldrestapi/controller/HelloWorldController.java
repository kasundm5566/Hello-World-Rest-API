package com.sample.helloworldrestapi.controller;

import com.sample.helloworldrestapi.exception.InvalidNameException;
import com.sample.helloworldrestapi.model.HelloWorldSuccessResponse;
import com.sample.helloworldrestapi.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping("/hello-world")
    public ResponseEntity<HelloWorldSuccessResponse> helloWorld(@RequestParam String name) {

        HelloWorldSuccessResponse helloWorldSuccessResponse = helloWorldService.helloWorld(name);

        if (StringUtils.hasText(helloWorldSuccessResponse.getMessage())) {
            return ResponseEntity.ok(helloWorldSuccessResponse);
        }

        throw new InvalidNameException("Invalid Input");
    }
}
