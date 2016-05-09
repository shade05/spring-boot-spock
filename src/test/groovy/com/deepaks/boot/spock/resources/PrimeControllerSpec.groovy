package com.deepaks.boot.spock.resources

import spock.lang.Specification;

class PrimeControllerSpec extends Specification {

    def "returns string 'prime' when service detects prime number"() {
        int p = 3
        def stub = {
            it == p ? true : false
        }

        expect:
        new PrimeController(primeService: stub).isPrime(p) == 'prime'
    }

    def "returns 'not prime' when service detects non-prime number"() {
        int n = 4
        def stub = { it == n ? false : true }

        expect:
        new PrimeController(primeService: stub).isPrime(n) == 'not prime'
    }
}
