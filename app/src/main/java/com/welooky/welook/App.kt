package com.welooky.welook

import android.app.Application
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager
import com.welooky.welook.api.remoteModule
import com.welooky.welook.ui.repositoryModule
import com.welooky.welook.ui.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.tencent.mmkv.MMKV


open class App : Application() {
    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, viewModule)
    }

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
        QMUISwipeBackActivityManager.init(this)
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModules)
        }
    }
}