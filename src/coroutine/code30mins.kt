package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() { // Executes in main thread


    println("Main program starts here: ${Thread.currentThread().name}")
    GlobalScope.launch{ // Thread: T1
        println("Fake work starts here: ${Thread.currentThread().name}") // Thread: T1
        delay(1000)// coroutine is suspended bu thread T1 is free (not blocked)
        println("Fake work ends here: ${Thread.currentThread().name}") // this will get executed either T1 or soe other thread
    }
    runBlocking { // creates a coroutine which is used to block the main thread
        delay(2000) // wait for the coroutine to finish; basically we are blocking the main thread by "runblocking coroutine"
        println("Main program ends here: ${Thread.currentThread().name}")
    }
}

