package com.welooky.welook.support

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.welooky.welook.api.WeResponse
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {

    val tipLiveData = MutableLiveData<String>()

    private var jobs = listOf<Job>()

    fun <T> launchNet(work: suspend (() -> WeResponse<T>?), callback: ((WeResponse<T>?) -> Unit)? = null) {
        jobs = jobs + CoroutineScope(Dispatchers.Main).launch {
            val data = withContext(Dispatchers.IO) {
                work()
            }
            callback?.let {
                if (data != null && !data.success()) {
                    tipLiveData.value = data.message
                } else {
                    it(data)
                }
            }
        }
    }

    fun <T : Any> launchWork(work: suspend (() -> T?), callback: ((T?) -> Unit)? = null) {
        jobs = jobs + CoroutineScope(Dispatchers.Main).launch {
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