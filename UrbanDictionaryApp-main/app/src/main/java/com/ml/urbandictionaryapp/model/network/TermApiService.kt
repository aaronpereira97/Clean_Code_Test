package com.ml.urbandictionaryapp.model.network

import com.ml.urbandictionaryapp.model.TermResponse
import com.ml.urbandictionaryapp.model.network.NetworkConstants.GET_TERMS_ENDPOINT
import com.ml.urbandictionaryapp.model.network.NetworkConstants.GET_TERMS_QUERY_NAME
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface TermApiService {

    @GET(GET_TERMS_ENDPOINT)
    fun getTerms(@Query(GET_TERMS_QUERY_NAME) term:String) : Deferred<TermResponse>
}