package com.challenger.tfl_challenger_api_clean_archichecture

import android.app.Application
import com.challenger.tfl_challenger_api_clean_archichecture.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    private val modules = listOf(apiModule, dataStoresModule, repositoriesModule, useCasesModule, viewmodelsModule,mappers)

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(applicationContext)
            modules(modules)
        }
    }
}