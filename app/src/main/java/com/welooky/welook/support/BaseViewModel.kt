package com.welooky.welook.support

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    private var jobs = listOf<Job>()

    fun launch(code: suspend CoroutineScope.() -> Unit) {
        jobs = jobs + CoroutineScope(Dispatchers.Main).launch(block = code)
    }

    override fun onCleared() {
        super.onCleared()
        jobs.forEach { it.cancel() }
    }
}