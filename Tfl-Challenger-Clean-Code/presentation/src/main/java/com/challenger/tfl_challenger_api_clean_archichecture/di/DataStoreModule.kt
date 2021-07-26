package com.challenger.tfl_challenger_api_clean_archichecture.di

import com.challenger.data.source.IRoadDataStore
import com.challenger.data.source.IRoadRemote
import com.challenger.data.source.RoadRemoteDataStore
import com.challenger.remote.GetRoadStatusRemoteImpl
import org.koin.dsl.module

val dataStoresModule = module {
    single<IRoadRemote> { GetRoadStatusRemoteImpl(get()) }
    single<IRoadDataStore> { RoadRemoteDataStore(get()) }
}