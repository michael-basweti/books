package com.mbasweti.books.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/greeting")
    public String firstApi() {
        return "hello mike";
    }

}
