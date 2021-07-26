package com.challenger.data.source

import com.challenger.data.models.RoadInfoEntity
import io.reactivex.Single

interface IRoadDataStore {
    fun getRoadStatus( roadName: String) : Single<List< RoadInfoEntity>>
}