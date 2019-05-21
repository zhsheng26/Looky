package com.welooky.welook.ui

import com.welooky.welook.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel { LoginViewModel(get()) }
}