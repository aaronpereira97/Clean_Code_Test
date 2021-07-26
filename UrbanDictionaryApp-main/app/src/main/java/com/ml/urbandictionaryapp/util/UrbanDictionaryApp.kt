package com.ml.urbandictionaryapp.util

import android.app.Application
import com.ml.urbandictionaryapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class UrbanDictionaryApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UrbanDictionaryApp)
            androidLogger(Level.ERROR)
            modules(listOf(networkModule, apiModule, databaseModule, repoModule, viewModelModule))
        }
    }
}