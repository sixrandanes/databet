package com.databet.ref.footballdata.competitions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@RestController
public class CompetitionController {

    @GetMapping("/competitions")
    public Mono<String> fetchCompetitions() {
        return Mono.just("Greetings from Spring Boot!");
    }

}
