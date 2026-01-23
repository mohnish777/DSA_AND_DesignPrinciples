package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.*

fun main()=runBlocking {
    println("Main program starts here: ${Thread.currentThread().name}")
    val job: Job = launch {
        for (i in 0..500){
            print("$i.")
            Thread.sleep(50)
        }
    }
    delay(200) // let's print few values before we cancel
    job.cancel() // it will not cancel the fsn as thread .sleep is not cooperative function or suspend function.
    job.join() // waits for the program to finish

    println("\nMain Program ends here: ${Thread.currentThread().name}")

}
