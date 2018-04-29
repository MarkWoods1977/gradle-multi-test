package com.example

import spock.lang.Specification

import static com.example.DemoGroovy.GREETING_TEXT

class DemoGroovyTest extends Specification {

    public static final String TEST_USERNAME = "Test"
    DemoGroovy demoGroovy

    void setup() {
        demoGroovy = new DemoGroovy()
    }

    def "Personal greeting"() {

        given: "I have a user"

        String userName = TEST_USERNAME

        when: "I call greeting"

        String greeting = demoGroovy.greeting(userName)

        then: "I receive a personal greeting"

        greeting == GREETING_TEXT + ' ' + TEST_USERNAME
    }

    def "Generic greeting"() {

        when: "I call greeting"

        String greeting = demoGroovy.greeting()

        then: "I receive a personal greeting"

        greeting == GREETING_TEXT
    }
}
