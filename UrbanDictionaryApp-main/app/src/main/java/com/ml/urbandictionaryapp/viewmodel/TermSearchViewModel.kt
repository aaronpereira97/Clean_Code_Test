package com.ml.urbandictionaryapp.viewmodel

import androidx.lifecycle.ViewModel
import com.ml.urbandictionaryapp.repository.TermRepository
import kotlinx.coroutines.*

class TermSearchViewModel(
    private val termRepository:TermRepository
) : ViewModel()
{
    private val supervisor = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + supervisor)

    val definitionSuccess = termRepository.definitionSuccess
    val definitionError = termRepository.definitionError

    fun findDefinitions(term:String){
        coroutineScope.launch {
            termRepository.getDefinitions(term)
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}