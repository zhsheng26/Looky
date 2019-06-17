package com.welooky.welook

import android.app.Application
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager
import com.welooky.welook.api.remoteModule
import com.welooky.welook.support.ReleaseTree
import com.welooky.welook.ui.repositoryModule
import com.welooky.welook.ui.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber


open class App : Application() {
    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, viewModule)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format(
                        "Class:%s: Line: %s, Method: %s",
                        super.createStackElementTag(element),
                        element.lineNumber,
                        element.methodName
                    )
                }
            })
        } else {
            Timber.plant(ReleaseTree())
        }
        QMUISwipeBackActivityManager.init(this)
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModules)
        }
    }
}