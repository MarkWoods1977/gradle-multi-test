package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class DemoApplicationTest extends Specification {

    @Autowired
    DemoJava demoJava

    @Autowired
    DemoGroovy demoGroovy

    def "Spring context loads"() {

        when: "the context starts"

        then: "it doesn't fail"
    }

    def "Can autowire java classes"() {

        when: "the context starts"

        then: "a class is injected"

        demoJava != null

        and: "a method can be executed"

        demoJava.greeting() == DemoJava.GREETING_TEXT
    }

    def "Can autowire groovy classes"() {

        when: "the context starts"

        then: "a class is injected"

        demoGroovy != null

        and: "a method can be executed"

        demoGroovy.greeting() == DemoGroovy.GREETING_TEXT
    }
}
