package com.deepaks.boot.spock.resources

import spock.lang.Specification;

class PrimeServiceImplSpec extends Specification {
 
    PrimeServiceImpl sut = new PrimeServiceImpl();
 
    def "test if the given number is prime"() {
        expect:
        sut.isPrime(n) == prime
 
        where:
        n | prime
        0 | false
        1 | false
        2 | true
        3 | true
        4 | false
        5 | true
        6 | false
        7 | true
    }
 
    def "check method argument constraints"() {
        when:
        sut.isPrime(-1)
 
        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'argument must not be negative'
    }
}
