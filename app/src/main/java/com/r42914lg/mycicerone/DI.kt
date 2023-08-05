package com.r42914lg.mycicerone

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MyApp.INSTANCE.router }
    single { MyApp.INSTANCE.navigatorHolder }
    viewModel { FragOneViewModel(get()) }
    viewModel { FragTwoViewModel(get(), get()) }
}