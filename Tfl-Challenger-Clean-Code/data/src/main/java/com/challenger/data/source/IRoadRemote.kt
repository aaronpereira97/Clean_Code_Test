package com.challenger.data.source

import com.challenger.data.models.RoadInfoEntity
import io.reactivex.Single

/**
 * Implementation of the [IRoadRemote] interface to provide a means of communicating
 * with the remote data source
 */
interface IRoadRemote {
    fun getRoadStatus(roadName: String) : Single<List<RoadInfoEntity>>
}

