package com.challenger.tfl_challenger_api_clean_archichecture.di

import com.challenger.data.mappers.RoadEntityMapper
import org.koin.dsl.module

val mappers = module {
    single { RoadEntityMapper() }
}