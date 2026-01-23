package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.*

//Periodically invoke a suspending function that checks for cancellation.
// - Only those suspending functions that belongs to kotlin.coroutines package will make coroutine cooperative
// delay(), yield(),  withContext(), withTimeout() etc. are the suspending functions that belongs to
// kotlinx.coroutines package


fun main()= runBlocking {
    println("Main program starts here: ${Thread.currentThread().name}")
    val job: Job = launch {
        for (i in 0..500){
            print("$i.")
            delay(50)
        }
    }
    delay(200) // let's print few values before we cancel

    //job.cancel()
    //job.join() // waits for the program to finish

    job.cancelAndJoin()

    println("\nMain Program ends here: ${Thread.currentThread().name}")

}
