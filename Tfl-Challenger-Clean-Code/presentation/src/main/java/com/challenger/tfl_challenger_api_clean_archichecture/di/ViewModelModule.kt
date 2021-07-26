package com.challenger.tfl_challenger_api_clean_archichecture.di

import com.challenger.tfl_challenger_api_clean_archichecture.viewmodels.RoadViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewmodelsModule = module {
    viewModel {
        RoadViewModel(
            get()
        )
    }
}