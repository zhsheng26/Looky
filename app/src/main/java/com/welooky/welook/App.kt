package com.welooky.welook

import android.app.Application
import com.welooky.welook.api.remoteModule
import com.welooky.welook.api.repositoryModule
import com.welooky.welook.ui.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class App : Application() {
    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, uiModule)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            // use the Android context given there
            androidContext(this@App)
            // load properties from assets/koin.properties file
            androidFileProperties()
            appModules
        }
    }
}