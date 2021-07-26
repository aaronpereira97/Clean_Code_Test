package com.ml.urbandictionaryapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ml.urbandictionaryapp.model.db.TermDao
import com.ml.urbandictionaryapp.model.network.TermApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class TermRepository(
    private val termDao: TermDao,
    private val termApiService: TermApiService
) {

    private var _definitionError = MutableLiveData<String>()
    val definitionError: LiveData<String>
    get() = _definitionError

    suspend fun getDefinitions(term:String){
        withContext(Dispatchers.IO){
            try {
                val definitions = termApiService.getTerms(term).await()
                termDao.insertTerms(definitions)
            }
            catch(exception:HttpException){
                _definitionError.value = "Failed to Load Definitions"
            }
        }
    }

    val definitionSuccess = termDao.getAllTerms()
}