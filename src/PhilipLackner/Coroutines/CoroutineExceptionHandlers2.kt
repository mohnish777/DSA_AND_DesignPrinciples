package PhilipLackner.Coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main() {

    runBlocking {
        try  {
            coroutineScope {
                val string = async {
                    delay(5000.milliseconds)
                    "Result"
                }

                val string2 = async<String> {
                    delay(50.milliseconds)
                    throw IllegalStateException("Opps")
                }
                println(string.await())
                println(string2.await())
            }

        } catch (e: Exception) {
            println("exception caught $e")
        }

    }
    // this code will cancel all the child coroutine as well
}