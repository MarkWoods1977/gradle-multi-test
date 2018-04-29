package com.example;

import org.springframework.stereotype.Component;

@Component
public class DemoJava {

    public static final String GREETING_TEXT = "Hello";

    public String greeting() {

        return GREETING_TEXT;
    }
}
