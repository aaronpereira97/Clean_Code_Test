package com.ml.urbandictionaryapp.di

import com.ml.urbandictionaryapp.model.network.TermApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideTermApi(retrofit: Retrofit) : TermApiService {
        return retrofit.create(TermApiService::class.java)
    }

    single { provideTermApi(get()) }
}