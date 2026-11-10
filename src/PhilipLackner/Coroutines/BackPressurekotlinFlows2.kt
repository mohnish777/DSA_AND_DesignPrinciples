package PhilipLackner.Coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds


fun main() {

    val scope1 = CoroutineScope(Dispatchers.IO)

    val parentJob = scope1.launch {

        flow {
            for (i in 0..10) {
                emit(i)
                delay(3000.milliseconds)
            }
        }.buffer().collect {
            delay(5000.milliseconds)
            println(it)
        }
    }

    runBlocking {
        parentJob.join()
    }
}