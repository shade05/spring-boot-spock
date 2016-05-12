package com.deepaks.boot.spock.resources

import com.deepaks.boot.spock.resources.utils.UnitTestUtils
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

    void "my test"() {
        given:
        Person person
        when:
        println 'person value ' + givenA + ", class: " + givenA.getClass()
        person = UnitTestUtils.createTestPerson(givenA)
        then:
        person.name == expected.name
        person.age == expected.age
        where:
        id| givenA        | expected
        1 | [name: "Joe"] | [name: "Joe", age: 45]
        2 | [age: 5]      | [name: "Jim Bob", age: 5]
    }
}
