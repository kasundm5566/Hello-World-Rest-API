package com.sample.helloworldrestapi.service.impl;

import com.sample.helloworldrestapi.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Value("${app.validation.name-first-half-regex}")
    private String nameFirstHalfRegex;

    @Override
    public String helloWorld(final String name) {
        if (name != null && Pattern.matches(nameFirstHalfRegex, name)) {
            return "Hello " + name;
        }
        return "";
    }
}