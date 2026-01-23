package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.*

fun main()= runBlocking {
    println("Main program starts here: ${Thread.currentThread().name}")
    val job: Job = launch {
        for (i in 0..500){
            print("$i.")
            yield() // faster than delay fsn
        }
    }
    delay(2) // let's print few values before we cancel

    job.cancelAndJoin()

    println("\nMain Program ends here: ${Thread.currentThread().name}")

}
