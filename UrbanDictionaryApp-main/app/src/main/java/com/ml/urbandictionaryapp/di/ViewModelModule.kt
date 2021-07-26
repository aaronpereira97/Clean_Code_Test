package com.ml.urbandictionaryapp.di

import com.ml.urbandictionaryapp.viewmodel.TermSearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
   viewModel { TermSearchViewModel(get()) }
}

