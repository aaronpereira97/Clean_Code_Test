package com.ml.urbandictionaryapp.model.network

import com.ml.urbandictionaryapp.BuildConfig

object NetworkConstants {

    const val API_KEY_HEADER_NAME = "x-rapidapi-key"
    const val API_KEY = BuildConfig.API_KEY

    const val TERM_BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com/"

    const val GET_TERMS_ENDPOINT = "define"
    const val GET_TERMS_QUERY_NAME = "term"
}