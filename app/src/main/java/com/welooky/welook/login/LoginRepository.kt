package com.welooky.welook.login

import com.welooky.welook.api.ApiStores
import com.welooky.welook.api.WeResponse
import com.welooky.welook.entity.UserObj

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val apiStores: ApiStores) {

    // in-memory cache of the loggedInUser object
    var user: UserObj? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
    }

    suspend fun login(username: String, password: String): WeResponse<UserObj> {
        return apiStores.loginAsync(username, password).await()
    }
}
