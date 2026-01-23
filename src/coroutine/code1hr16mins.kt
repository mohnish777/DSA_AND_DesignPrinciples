package com.example.designPrinciplesAndAlgo.coroutine

import kotlinx.coroutines.*

fun main()= runBlocking {
    println("Main program starts here: ${Thread.currentThread().name}")
    val job: Job = launch(Dispatchers.Default) {
        for (i in 0..50000){
            if(!isActive){ // now isActive is true
                break // or return @launch
            }
            print("$i.")
            Thread.sleep(1) //
        }
    }

    delay(10) // let's print few values before we cancel
    //job.cancelAndJoin() //once program comes here; isActive will become false and it will end the launch coroutine.

    println("\nMain Program ends here: ${Thread.currentThread().name}")

}
