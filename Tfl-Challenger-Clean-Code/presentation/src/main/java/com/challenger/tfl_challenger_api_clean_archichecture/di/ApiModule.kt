package com.challenger.tfl_challenger_api_clean_archichecture.di

import com.challenger.remote.ApiService
import com.challenger.remote.utils.TFL_BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    fun provideGitApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl(TFL_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ApiService::class.java)
    }

    single { provideGitApi()}
}