package com.sample.helloworldrestapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HelloWorldErrorResponse {
    private String error;
}
