package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getHtml() {
        return "Siemankooo!";
    }

    @GetMapping(value = "/echo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echo() {
        return "Hello There";
    }

    @GetMapping(value = "/echo2/{parametr}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echo2(@PathVariable("parametr") String name) {
        return name;
    }
}
