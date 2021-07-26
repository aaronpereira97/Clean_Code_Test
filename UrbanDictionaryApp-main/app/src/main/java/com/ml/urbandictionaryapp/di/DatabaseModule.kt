package com.ml.urbandictionaryapp.di

import android.app.Application
import androidx.room.Room
import com.ml.urbandictionaryapp.model.db.DatabaseConstants.DATABASE_NAME
import com.ml.urbandictionaryapp.model.db.TermDao
import com.ml.urbandictionaryapp.model.db.TermDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application) : TermDatabase {
        return Room.databaseBuilder(application, TermDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDAO(database: TermDatabase) : TermDao {
        return database.termDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDAO(get()) }
}