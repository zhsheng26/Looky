package com.welooky.welook.support

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

/**
 * @author zhangsheng
 * @date 2019/5/21
 */


class RxViewModel : ViewModel() {

    val actionStream = PublishSubject.create<Action>()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun Disposable.track() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}