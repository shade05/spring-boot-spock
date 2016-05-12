package com.deepaks.boot.spock.resources.utils

import com.deepaks.boot.spock.resources.Person

/**
 * Created by deepaks on 5/10/16.
 */
class UnitTestUtils {

    static Person createTestPerson(LinkedHashMap overrides = [:]) {
        Person p = new Person(name: "Jim Bob", age: 45)
        overrides.each { String key, value ->
            println "key: " + key + ", value: " + value
            if (p.hasProperty(key)){
                p."$key" = value
            } else {
                println "Error: Trying to add property that doesn't exist"
            }
        }
        return p
    }
}
