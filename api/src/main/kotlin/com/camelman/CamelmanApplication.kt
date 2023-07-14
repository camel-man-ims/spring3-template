package com.camelman

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CamelmanApplication

fun main(args: Array<String>) {
    runApplication<CamelmanApplication>(*args)
}
