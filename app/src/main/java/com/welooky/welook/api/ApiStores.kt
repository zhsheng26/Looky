package com.welooky.welook.api

import com.welooky.welook.entity.UserObj
import kotlinx.coroutines.Deferred
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiStores {
    @POST("search/users")
    @Headers("Accept: application/json")
    fun loginAsync(@Query("username") username: String, @Query("password") password: String): Deferred<WeResponse<UserObj>>
}