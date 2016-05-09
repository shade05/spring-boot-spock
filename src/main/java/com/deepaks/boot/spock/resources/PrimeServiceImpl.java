package com.deepaks.boot.spock.resources;

import org.springframework.stereotype.Service;

@Service
public class PrimeServiceImpl implements PrimeService {
 
    @Override
    public boolean isPrime(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("argument must not be negative");
        }
 
        if (number <= 2) {
            return number == 2 ? true : false;
        }
 
        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
 
        return true;
    }
}