package PhilipLackner.Coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.time.Duration.Companion.milliseconds

fun main() {

    runBlocking {
        val handler = CoroutineExceptionHandler { context, error ->
            val task = context[CoroutineName]?.name ?: "unNamed Task"
            println("$task failed error message ${error.message}")
        }

        supervisorScope {
            for(id in 0 until 5) {
                launch(Dispatchers.Default + handler + CoroutineName("Worker-$id")) {
                    delay(4000.milliseconds)
                    if (id == 3) {
                        launch {
                            throw Exception("")
                        }
                    }
                    println("worker $id completed")
                }
            }
        }
        println("All workers finished!")

    }
}