package PhilipLackner.Coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


suspend fun main() {
    try {
        coroutineScope {
            launch {
                try {
                    launch {
                        throw Exception() // exception will propogate up
                    }
                } catch (e: Exception) {
                    println("caught the exception in grand child")
                }

            }
        }
    } catch (e: Exception) {
        println("Caught exception: $e")
    }

}