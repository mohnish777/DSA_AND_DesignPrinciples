package PhilipLackner.Coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.time.Duration.Companion.milliseconds

fun main() {

    runBlocking {
        supervisorScope {
            val tasks = listOf(
                async {
                    delay(5000.milliseconds)
                    "result 1"
                },
                async {
                    delay(50.milliseconds)
                    throw IllegalStateException("Oops")
                },
                async {
                    delay(7000.milliseconds)
                    "Result 3"
                }
            )

            tasks.forEachIndexed { index, task ->
                try {
                    println("Task ${index + 1}: ${task.await()}")
                } catch (e: Exception) {
                    println("Task ${index + 1} failed: ${e.message}")
                }
            }
        }
    }
}

fun main2() {
    runBlocking {
        supervisorScope {
            launch {
                delay(5000.milliseconds)
                println("Task 1 finished")
            }

            launch {
                delay(50.milliseconds)
                throw IllegalStateException("Oops")
            }

            launch {
                delay(7000.milliseconds)
                println("Task 3 finished")
            }
        }

        println("All tasks finished")
    }
}