package com.welooky.welook.support

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.welooky.welook.api.WeResponse
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {

    val tipLiveData = MutableLiveData<String>()

    private var job = Job()

    fun <T> launchNet(work: suspend (() -> WeResponse<T>?), callback: ((WeResponse<T>?) -> Unit)? = null) {
        viewModelScope.launch {
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
        CoroutineScope(Dispatchers.Main + job).launch {
            val data = withContext(Dispatchers.IO) {
                work()
            }
            callback?.let {
                it(data)
            }
        }
    }

    fun launch(code: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(block = code)
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

}