package com.welooky.welook.api

import com.welooky.welook.entity.UserObj
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiStores {
    @POST("login")
    @FormUrlEncoded
    fun loginAsync(@Field("username") username: String, @Field("password") password: String): Deferred<WeResponse<UserObj>>
}