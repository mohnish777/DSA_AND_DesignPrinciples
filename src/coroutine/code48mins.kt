package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.*


fun main()= runBlocking { // Creates a blocking coroutine that executes in current thread (main)

        println("Main program starts here: ${Thread.currentThread().name}") // main thread
        launch{ // Thread: main (as its not global; it will inherit Parent's Thread)
            println("Fake work starts here: ${Thread.currentThread().name}") // Thread: main
            delay(1000)// coroutine is suspended bu Thread: main is free (not blocked)
            println("Fake work ends here: ${Thread.currentThread().name}") // this will get executed either main or some other thread
        }
        delay(2000) // wait for the coroutine to finish; basically we are blocking the main thread by "runblocking coroutine"
        println("Main program ends here: ${Thread.currentThread().name}")
    }
