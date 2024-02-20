package com.example.NNPIA_CV02.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
/**
 * Controller slouží k vytváření webových controllerů které vrací pohledy, RestController zase vytváří service, které vrací JSON
 */
public class HelloController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping(value = "/query1/{msg}")
    public String greetingParamMethodString(@RequestParam String msg) {
        return "Hello string: " + msg;
    }

    @RequestMapping(value = "/query2/{msg}", method = RequestMethod.GET)
    public String greetingParamMethodGet(@PathVariable String msg) {
        return "Hello get: " + msg;
    }

    @GetMapping(value = "{query3}")
    public String greetingParamMethod(@PathVariable("query3") String msg) {
        return "Hello query: " + msg;
    }

}
