package org.github.frikit.contactbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContactBookApplication

fun main(args: Array<String>) {
    runApplication<ContactBookApplication>(*args)
}
