package com.deepaks.boot.spock.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PrimeController {

    @Autowired
    PrimeService primeService;

    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "error";
    }

    @RequestMapping("/prime")
    String isPrime(@RequestParam int n) {
        return primeService.isPrime(n) ? "prime" : "not prime";
    }
}