package com.sample.helloworldrestapi.service;

import com.sample.helloworldrestapi.model.HelloWorldSuccessResponse;

public interface HelloWorldService {
    HelloWorldSuccessResponse helloWorld(String name);
}