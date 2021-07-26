package com.ml.urbandictionaryapp.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ml.urbandictionaryapp.model.TermResponse
import com.ml.urbandictionaryapp.model.db.DatabaseConstants.DATABASE_VERSION

@Database(entities = [TermResponse::class], version = DATABASE_VERSION, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TermDatabase : RoomDatabase() {
    abstract val termDao:TermDao
}