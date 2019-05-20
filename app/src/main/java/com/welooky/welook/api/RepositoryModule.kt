package com.welooky.welook.api

import com.welooky.welook.login.LoginRepository
import com.welooky.welook.login.LoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LoginRepository> { LoginRepositoryImpl(get()) }
}