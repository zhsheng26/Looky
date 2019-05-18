package com.welooky.welook.login

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.welooky.welook.api.WeResponse
import com.welooky.welook.entity.UserObj
import com.welooky.welook.support.BaseViewModel

class LoginViewModel(private val loginRepository: LoginRepository) : BaseViewModel() {


    val loginResult = MutableLiveData<WeResponse<UserObj>>()

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        launch {
            val result = loginRepository.login(username, password)
        }

    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
        } else if (!isPasswordValid(password)) {
        } else {
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5;
    }
}
