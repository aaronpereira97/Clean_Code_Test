package com.challenger.tfl_challenger_api_clean_archichecture.di

import com.challenger.data.repositories.RoadRepository
import com.challenger.domain.repository.IRoadRepository
import org.koin.dsl.module

val repositoriesModule = module{

    single<IRoadRepository> { RoadRepository(get(), get()) }

}