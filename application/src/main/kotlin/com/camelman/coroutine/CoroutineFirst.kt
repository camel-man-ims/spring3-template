package com.camelman.coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

class CoroutineFirst

fun main() {
    println("start")

    runBlocking {
        launch { task1() }
        launch { task2() }
        println("call task1, task2 from ${Thread.currentThread()}")
    }
    println("end")
}

suspend fun task1() {
    println("start task1 in Thread ${Thread.currentThread()}")
    yield()
    println("end task1 in Thread ${Thread.currentThread()}")
}

suspend fun task2() {
    println("start task2 in Thread ${Thread.currentThread()}")
    yield()
    println("end task2 in Thread ${Thread.currentThread()}")
}
