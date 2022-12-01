package de.akademie.swe.application.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
public class PersonController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello Yolla";
    }
}
