package com.ml.urbandictionaryapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class TermResponse (
	@PrimaryKey val termResponseID: Int = 0,
	@SerializedName("list") val terms : List<Term>
)
