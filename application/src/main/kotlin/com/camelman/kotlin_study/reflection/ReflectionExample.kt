package com.camelman.kotlin_study.reflection

data class User(val name: String, val age: Int)

fun main(){
    val user = User("John", 30)
    val kProperty = User::name

    println(kProperty.get(user)) // Outputs "John"
}
