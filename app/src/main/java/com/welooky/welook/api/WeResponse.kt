package com.welooky.welook.api

data class WeResponse<T>(
    val code: Int = 0,
    val content: T? = null,
    val message: String? = null
) {
    fun success(): Boolean {
        return code == 200
    }
}