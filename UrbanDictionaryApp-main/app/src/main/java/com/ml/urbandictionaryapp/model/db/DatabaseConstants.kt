package com.ml.urbandictionaryapp.model.db

object DatabaseConstants {

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "terms.db"

    const val SELECT_ALL_TERMS_QUERY = "SELECT * FROM TermResponse"
    const val DELETE_ALL_TERMS_QUERY = "DELETE FROM TermResponse"
}