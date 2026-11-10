package PhilipLackner.Coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main() {

//    Thread {
//        while (true) {
//            // do something
//            Thread.sleep(1000)
//        }
//    }


    val scope1 = CoroutineScope(Dispatchers.Default)
    println("Started")
    val parentJob = scope1.launch {
        val childJob = launch {
            val grandChild = launch {
                delay(5000.milliseconds)
                println("Grand Child job finished")
            }
            println("Child job reached its end")
        }
        println("Parent job reached its end")
    }

    scope1.launch {
        delay(300.milliseconds)
        parentJob.cancel() // cancellation flows downwards (propogates downwards) do - meaning it will cancel all its child coroutines
    }

    runBlocking {
        parentJob.join()
        println("Finshing...")
    }

}