package com.example.lanecrowd.util

import kotlinx.coroutines.*

object Coroutines {

    //CoroutineExceptionHandler is a global exception handler
    private val exceptionHandler = CoroutineExceptionHandler {   context, exception ->
    }

    fun main(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch(exceptionHandler) {
            work()


        }



    fun io(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.IO).launch(exceptionHandler) {
            work()
        }

}