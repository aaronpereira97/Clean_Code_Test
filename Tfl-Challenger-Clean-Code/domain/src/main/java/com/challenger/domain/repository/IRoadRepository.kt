package com.challenger.domain.repository

import com.challenger.domain.models.RoadInfo
import io.reactivex.Single

/**
 * Implementation of the [IRoadRepository] interface to provide a means of communicating
 * with the data layer
 */
interface IRoadRepository{

    fun getRoadStatus(roadName: String): Single<RoadInfo>
}