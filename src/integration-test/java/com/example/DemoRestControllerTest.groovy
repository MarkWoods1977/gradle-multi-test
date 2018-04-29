package com.example

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

@SpringBootTest
class DemoRestControllerTest extends Specification {

    public static final String TEST_USERNAME = "mark"
    public static final String EXPECTED_GREETING = DemoGroovy.GREETING_TEXT + " " + TEST_USERNAME
    MockMvc mockMvc
    DemoGroovy demoGroovy
    DemoRestController demoRestController

    void setup() {
        demoGroovy = Mock(DemoGroovy)
        demoRestController = new DemoRestController(demoGroovy)
        mockMvc = standaloneSetup(demoRestController).build()
        demoGroovy.greeting(TEST_USERNAME) >> EXPECTED_GREETING
    }

    def "controller returns with a greeting"() {

        given: "a username is passed"

        String username = TEST_USERNAME

        when: "the greeting endpoint is called"

        def response = mockMvc.perform(get("/" + username + "/greeting"))

        then: "the call is successful"

        response.andExpect(status().isOk())

        and: "the greeting is returned"

        response.andExpect(content().string(EXPECTED_GREETING))
    }

    def "controller fails with a user"() {

        given: "no username is passed"

        String username = ""

        when: "the greeting endpoint is called"

        def response = mockMvc.perform(get("/" + username + "/greeting"))

        then: "a client error is thrown"

        response.andExpect(status().is4xxClientError())
    }
}
