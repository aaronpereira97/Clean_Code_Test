package com.ml.urbandictionaryapp.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ml.urbandictionaryapp.model.TermResponse
import com.ml.urbandictionaryapp.model.db.DatabaseConstants.DELETE_ALL_TERMS_QUERY
import com.ml.urbandictionaryapp.model.db.DatabaseConstants.SELECT_ALL_TERMS_QUERY

@Dao
interface TermDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTerms(terms: TermResponse)

    @Query(SELECT_ALL_TERMS_QUERY)
    fun getAllTerms() : LiveData<TermResponse>

    @Query(DELETE_ALL_TERMS_QUERY)
    fun deleteAllTerms()
}