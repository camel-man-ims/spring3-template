package com.camelman.design_pattern.chap2_creational_pattern

interface Prototype {
    fun clone(): Prototype
}

data class Configuration(
    var url: String,
    var timeout: Int
) : Prototype {
    override fun clone(): Prototype {
        return copy()
    }
}

// Client Code
fun main() {
    val prototypeConfig = Configuration(url = "http://localhost", timeout = 5000)

    val newConfig = prototypeConfig.clone() as Configuration
    newConfig.timeout = 3000

    println("Prototype Config: $prototypeConfig")
    println("New Config: $newConfig")
}
