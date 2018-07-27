package com.databet.social;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DatabetApplication {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
