package com.ml.urbandictionaryapp.di

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.ml.urbandictionaryapp.model.network.NetworkConstants.API_KEY
import com.ml.urbandictionaryapp.model.network.NetworkConstants.API_KEY_HEADER_NAME
import com.ml.urbandictionaryapp.model.network.NetworkConstants.TERM_BASE_URL
import okhttp3.*
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

val networkModule = module {

    //Make a space to cache data from the network
    fun provideCache(application: Application) : Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    fun provideOKHttpClient(cache: Cache) : OkHttpClient{

        val interceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response =  chain.run {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader(API_KEY_HEADER_NAME, API_KEY)
                        .build()
                )
            }

        }
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)
            .protocols((Collections.singletonList(Protocol.HTTP_1_1)))
            .addInterceptor(interceptor)

        return okHttpClientBuilder.build()
    }

    fun provideGson() : Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideRetroFit(factory: Gson, okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(TERM_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(factory))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    single { provideCache(androidApplication()) }
    single { provideOKHttpClient(get()) }
    single { provideGson() }
    single { provideRetroFit(get(), get()) }
}