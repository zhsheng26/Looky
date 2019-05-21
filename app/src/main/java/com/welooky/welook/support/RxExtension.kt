package com.welooky.welook.support

import io.reactivex.Observable

/**
 * @author zhangsheng
 * @date 2019/5/21
 */

interface Action

inline fun <T, reified E : T> Observable<in T>.filterTo(
    @Suppress("UNUSED_PARAMETER") target: Class<E>
): Observable<out E> = this.filter {
    when (it) {
        is E -> true
        else -> false
    }
}.map { it as E }