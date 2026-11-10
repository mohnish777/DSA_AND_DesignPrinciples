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
//            Thread.sleep(5000)
//        }
//    }

    val scope1 = CoroutineScope(Dispatchers.Default)

    val parentJob = scope1.launch {
        val childJob = launch {
            val grandChildJob = launch {
                delay(5000.milliseconds)
                throw RuntimeException("Opps") // propagates upwards and cancels the parent coroutine, which leads to cancellation of children coroutine
                println("Grand child job finished")
            }

            val grandChildJob2 = launch {
                println("2nd grand child")
                delay(6000.milliseconds)
            }

            println("Child Job finished")
        }

        println("parent job finished")

    }

    runBlocking {
        parentJob.join()
        println("Finished ...")
    }

}