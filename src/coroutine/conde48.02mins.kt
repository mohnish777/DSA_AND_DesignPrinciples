package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.*


fun main()= runBlocking { // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts here: ${Thread.currentThread().name}") // main thread
    val job:Job = launch{ // Thread: main (as its not global; it will inherit Parent's Thread)
        println("Fake work starts here: ${Thread.currentThread().name}") // Thread: main
        delay(1000)// coroutine is suspended bu Thread: main is free (not blocked)
        println("Fake work ends here: ${Thread.currentThread().name}") // this will get executed either main or some other thread
    }
    job.join() // this job object waits until the coroutine finishes its execution; after that next statement will be executed.
    println("Main program ends here: ${Thread.currentThread().name}")
}

//launch function returns Job object; therefore by using this object we can control the respective coroutine

//val job: Job = launch{ // C1 (new coroutine gets launched)
//    delay(1000)
//}

// 'launch' coroutine builder(Fire or Forget)
//1. Launches a new coroutine without blocking the current thread
//        -- Inherits the thread & coroutine scope of the immediate parent coroutine
//2. Returns a reference to Job object
//3. Using Job object you can cancel the coroutine or wait for coroutine to finish.
