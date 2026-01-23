package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.*

fun main()= runBlocking { // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts here: ${Thread.currentThread().name}") // main thread
    val deferredObj: Deferred<Int> = async{ // Thread: main (as its not global; it will inherit Parent's Thread)
        println("Fake work starts here: ${Thread.currentThread().name}") // Thread: main
        delay(1000)// coroutine is suspended bu Thread: main is free (not blocked)
        println("Fake work ends here: ${Thread.currentThread().name}") // this will get executed either main or some other thread
        15 // this will get returned
    }
    //deferredObj.join() // this job object waits until the coroutine finishes its execution; after that next statement will be executed.

    // of you want to use 15 in your obj then use obj.await() instead of obj.join()
    val num:Int = deferredObj.await()
    println("Main program ends here: ${Thread.currentThread().name}")
    println(num)
}

//1. Async Launches a new coroutine without blocking the current thread
//        -- Inherits the thread & coroutine scope of the immediate parent coroutine
//2. Returns a reference to Deferred object
//3. Using Deferred object you can cancel the coroutine or wait for coroutine to finish.


// Launch and async will never block the thread in which it operates but runBlocking will always block the thread in which it operates.
