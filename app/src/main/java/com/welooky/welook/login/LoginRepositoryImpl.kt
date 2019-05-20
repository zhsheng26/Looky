package com.welooky.welook.login

import com.welooky.welook.api.ApiStores
import com.welooky.welook.api.WeResponse
import com.welooky.welook.entity.UserObj

/**
 * @author zhangsheng
 * @date 2019/5/20
 */
class LoginRepositoryImpl(private val apiStores: ApiStores) : LoginRepository {
    // in-memory cache of the loggedInUser object
    var user: UserObj? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    override suspend fun login(username: String, password: String): WeResponse<UserObj> {
        return apiStores.loginAsync(username, password).await()
    }
}