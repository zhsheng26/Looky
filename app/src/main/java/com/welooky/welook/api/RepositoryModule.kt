package com.welooky.welook.api

import com.welooky.welook.login.LoginRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LoginRepository(get()) }
}