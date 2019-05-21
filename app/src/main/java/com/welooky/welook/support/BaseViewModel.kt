package com.welooky.welook.support

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {
    private var jobs = listOf<Job>()

    fun <T : Any> launch(work: suspend (() -> T?), callback: ((T?) -> Unit)? = null) {
        jobs = jobs + CoroutineScope(Dispatchers.Main).launch {
            println(this.coroutineContext)
            val data = withContext(Dispatchers.IO) {
                work()
            }
            callback?.let {
                it(data)
            }
        }
    }

    fun launch(code: suspend CoroutineScope.() -> Unit) {
        jobs = jobs + CoroutineScope(Dispatchers.Main).launch(block = code)
    }

    override fun onCleared() {
        super.onCleared()
        jobs.forEach { it.cancel() }
    }

}