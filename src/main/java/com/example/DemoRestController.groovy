package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/{userName}/greeting")
class DemoRestController {

    private DemoGroovy demoGroovy

    @Autowired
    DemoRestController(DemoGroovy demoGroovy) {
        this.demoGroovy = demoGroovy
    }

    @RequestMapping(method = RequestMethod.GET)
    String readBookmarks(@PathVariable String userName) {
        demoGroovy.greeting(userName)
    }
}
