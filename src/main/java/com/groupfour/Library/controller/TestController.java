package com.groupfour.Library.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class TestController {
    @RequestMapping("/test")
    public Mono<String> test(){
        return Mono.just("Hello World!");
    }
}
