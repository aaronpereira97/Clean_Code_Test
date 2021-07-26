package com.challenger.domain.models

data class RoadInfo (val type:String,val displayName:String , val id:String, val statusSeverity:String, val statusSeverityDescription: String,
                     val bounds: String, val envelope: String, val url:String)