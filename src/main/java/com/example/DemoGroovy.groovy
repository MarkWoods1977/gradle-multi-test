package com.example

import org.springframework.stereotype.Component

@Component
class DemoGroovy {

    static final String GREETING_TEXT = "Hello"

    String greeting() {

        return GREETING_TEXT
    }

    String greeting(String userName) {

        return GREETING_TEXT + ' ' + userName
    }
}
