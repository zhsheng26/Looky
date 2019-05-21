package com.welooky.welook.ui

import com.welooky.welook.ui.login.LoginRepository
import com.welooky.welook.ui.login.LoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LoginRepository> { LoginRepositoryImpl(get()) }
}