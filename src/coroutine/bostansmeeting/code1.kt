package com.example.designPrinciplesAndAlgo.coroutine.bostansmeeting

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.concurrent.thread
import kotlin.coroutines.resumeWithException

class ConvertToSuspensionExample {

    fun createMockApi(): CallbackApi {
        return object : CallbackApi {
            override fun fetchData(callback: (String?, Throwable?) -> Unit) {
                thread { // Simulate async behavior
                    Thread.sleep(1000)
                    callback("Fetched Data", null)
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun fetchConvertToSuspend(callbackApi: CallbackApi) : String {
        return suspendCancellableCoroutine { cont ->
            callbackApi.fetchData { result, error ->
                if(error != null){
                    cont.resumeWithException(Exception("Some Error"))
                }else{
                    cont.resume(result!!){
                        println("+++++ on cancelled ${it.message}")
                    }
                }
            }
        }
    }
}

interface CallbackApi{
    fun fetchData(callback: (String?, Throwable?) -> Unit)

}


fun main()= runBlocking(){

    val convertToSuspensionExample = ConvertToSuspensionExample()

    /*convertToSuspensionExample.createMockApi().fetchData { result, error ->

        println("++++ result: $result  +++ erro: $error")

    }*/

    val mockApi = convertToSuspensionExample.createMockApi()

    val result = convertToSuspensionExample.fetchConvertToSuspend(mockApi)


    println("++++ main completed +++ $result")

}
