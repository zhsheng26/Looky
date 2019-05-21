package com.welooky.welook.ui.login

import com.welooky.welook.api.WeResponse
import com.welooky.welook.entity.UserObj

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

interface LoginRepository {
    suspend fun login(username: String, password: String): WeResponse<UserObj>
}
