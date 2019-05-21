package com.welooky.welook.support

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    private var compositeDisposable: CompositeDisposable? = null

    protected fun Disposable.track() {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.add(this)
    }

    override fun onDestroy() {
        if (compositeDisposable != null) {
            compositeDisposable!!.clear()
        }
        super.onDestroy()
    }

}
