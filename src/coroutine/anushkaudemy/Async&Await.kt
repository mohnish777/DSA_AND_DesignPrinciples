package com.example.designPrinciplesAndAlgo.coroutine.anushkaudemy

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun getStock1(): Int{
    delay(10000)
    println("stock 1 returned")
    return 55000
}

suspend fun getStock2(): Int{
    delay(8000)
    println("stock 2 returned")
    return 35000
}

fun main(): Unit = runBlocking {
    // coroutine in this main fsn runs in sequence first it will calculate getStock1() and then getStock2()
    // its not async
    launch{
        println("Calculation stated")
        val stock1 = getStock1()
        val stock2 = getStock2()
        val total = stock1 +stock2
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
