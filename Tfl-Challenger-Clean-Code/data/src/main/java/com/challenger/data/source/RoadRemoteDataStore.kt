package com.challenger.data.source

import com.challenger.data.models.RoadInfoEntity
import io.reactivex.Single



class RoadRemoteDataStore(private val roadRemote: IRoadRemote) : IRoadDataStore {

    override fun getRoadStatus(roadName: String): Single<List<RoadInfoEntity>> {
         return roadRemote.getRoadStatus(roadName)
    }

}