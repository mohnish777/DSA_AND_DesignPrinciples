package com.example.designPrinciplesAndAlgo.coroutine.anushkaudemy

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking



fun main(): Unit = runBlocking {
    // coroutine in this main fsn runs in async it will calculate getStock1() and getStock2()
    // at the same time
    launch{
        println(Thread.currentThread().name)
        println("Calculation stated")
        val stock1 = async(IO) { // you can run this is bg thread too.
            println(Thread.currentThread().name)
            getStock1()
        }
        val stock2 = async {
            getStock2()
        }
        val total = stock1.await() + stock2.await()
        // assigning to ui can be done here, since this is main thread
        // eg showing value on toast msg.
        println("Total = $total")
    }

    CoroutineScope(IO).launch{
        delay(30000)
        println("Calculation stated")
        val stock1 = getStock1()
        val stock2 = getStock2()
        val total = stock1 +stock2
        println("Total = $total")
    }
    println("Will function end after this print statement?")

}

//fun main() {
//    CoroutineScope(IO).launch{
//        println("Calculation stated")
//        val stock1 = getStock1()
//        val stock2 = getStock2()
//        val total = stock1 +stock2
//        println("Total = $total")
//    }
//    println("Will function end after this print statement?")
//}
