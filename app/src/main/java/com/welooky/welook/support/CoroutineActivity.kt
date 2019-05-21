package com.welooky.welook.support

import android.annotation.SuppressLint
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


@SuppressLint("Registered")
open class CoroutineActivity : BaseActivity() {
    private val parentJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + parentJob)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        parentJob.cancel()
        super.onDestroy()
    }
}
