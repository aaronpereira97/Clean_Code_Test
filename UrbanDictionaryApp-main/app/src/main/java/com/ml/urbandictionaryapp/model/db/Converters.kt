package com.ml.urbandictionaryapp.model.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ml.urbandictionaryapp.model.Term

/**
 * Class is used by Room database to convert unknown data types
 * to JSON (String format) and then back to their original data types
 * when retrieved from the database.
 */
class Converters{

    /**
     * Function converts list of Term objects to String
     * @param terms
     * @return String representation of the list
     */
    @TypeConverter
    fun termListToJson(terms: List<Term>) : String{
        return Gson().toJson(terms)
    }

    /**
     * Function takes a parameter of string and retrieves a list
     * @param value
     * @return List of Term objects
     */
    @TypeConverter
    fun termListFromJson(value: String): List<Term> {
        return Gson().fromJson(value, Array<Term>::class.java).toList()
    }
}