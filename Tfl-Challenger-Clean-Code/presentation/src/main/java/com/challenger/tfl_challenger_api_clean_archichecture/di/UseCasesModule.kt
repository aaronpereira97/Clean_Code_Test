package com.challenger.tfl_challenger_api_clean_archichecture.di

import com.challenger.domain.executor.JobExecutor
import com.challenger.domain.usercases.GetRoadInfo
import com.challenger.tfl_challenger_api_clean_archichecture.executor.UiThread
import org.koin.dsl.module

val useCasesModule = module {
    single { GetRoadInfo(get(), JobExecutor(), UiThread()) }
}