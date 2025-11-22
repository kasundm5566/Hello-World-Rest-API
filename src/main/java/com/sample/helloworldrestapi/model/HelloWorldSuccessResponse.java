package com.sample.helloworldrestapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HelloWorldSuccessResponse {
    private String message;
}
