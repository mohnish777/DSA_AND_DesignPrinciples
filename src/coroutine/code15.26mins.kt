package com.example.designPrinciplesAndAlgo.coroutine

import kotlin.concurrent.thread

fun main() { // executes in main thread
    println("Main program starts here: ${Thread.currentThread().name}")

    thread{ // background thread gets created
        println("Fake work starts here: ${Thread.currentThread().name}")
//        Thread.sleep(1000)
        println("Fake work starts here: ${Thread.currentThread().name}")
    }

    println("Main program starts here: ${Thread.currentThread().name}")
}
