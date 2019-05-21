package com.welooky.welook.ui

import android.os.Bundle
import com.welooky.welook.R
import com.welooky.welook.support.BaseActivity
import io.reactivex.Observable
import org.jetbrains.anko.startActivity
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Observable.timer(3, TimeUnit.SECONDS)
            .subscribe {
                startActivity<MainActivity>()
                finish()
            }
            .track()
    }
}
