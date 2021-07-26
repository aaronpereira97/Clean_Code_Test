package com.ml.urbandictionaryapp.di

import com.ml.urbandictionaryapp.model.db.TermDao
import com.ml.urbandictionaryapp.model.network.TermApiService
import com.ml.urbandictionaryapp.repository.TermRepository
import org.koin.dsl.module

val repoModule = module {
    fun provideRepository(dao: TermDao,apiService: TermApiService) : TermRepository {
        return TermRepository(dao, apiService)
    }

    single { provideRepository(get(), get()) }
}