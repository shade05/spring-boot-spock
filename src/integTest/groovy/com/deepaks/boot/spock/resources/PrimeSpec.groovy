package com.deepaks.boot.spock.resources

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration

import com.deepaks.boot.spock.DemoApplication;

import spock.lang.Specification


@ContextConfiguration(loader = SpringApplicationContextLoader, classes = DemoApplication)
@WebAppConfiguration
@IntegrationTest
class PrimeSpec extends Specification {
 
    @Value('${local.server.port}')
    int port;
 
    def "server answers with 'prime' or 'not prime' or 'error'"() {
        expect:
        "http://localhost:$port/prime?n=$n"
            .toURL().text == response
        println response
 
        where:
        n  | response
        23 | 'prime'
        42 | 'not prime'
        -1 | 'error'
    }
}
