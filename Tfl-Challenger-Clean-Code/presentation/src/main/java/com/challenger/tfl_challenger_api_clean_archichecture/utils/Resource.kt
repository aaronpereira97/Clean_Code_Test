package com.challenger.tfl_challenger_api_clean_archichecture.utils

sealed class Resource<out T> {
    data class  Loading(val msg: String?= null) : Resource<Nothing>()
    data class Success<out R> (val result: R) : Resource<R>()
    data class Error(val message: String?) : Resource<Nothing>()

}