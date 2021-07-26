package com.challenger.data.models

import com.google.gson.annotations.SerializedName

data class RoadInfoEntity(@SerializedName("\$type") val type:String, val displayName:String,val id:String, val statusSeverity:String, val statusSeverityDescription: String,
                          val bounds: String, val envelope: String, val url:String) {
}