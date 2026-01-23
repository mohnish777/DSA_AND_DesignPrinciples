package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() { // executes in main thread
    println("Main program starts here: ${Thread.currentThread().name}")

    GlobalScope.launch{ // background thread gets created
        println("Fake work starts here: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work starts here: ${Thread.currentThread().name}")
    }

    println("Main program starts here: ${Thread.currentThread().name}")
}
// here things are little different compared to usual Thread.
// while working with coroutines it will directly complete the MAIN Thread if background coroutine thread is taking time.

//GlobalScope.launch is non blocking in nature
// runblocking blocks the thread in which it operates.
