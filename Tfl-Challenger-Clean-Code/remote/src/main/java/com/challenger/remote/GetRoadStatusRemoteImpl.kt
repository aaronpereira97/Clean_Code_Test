package com.challenger.remote

import com.challenger.data.models.RoadInfoEntity
import com.challenger.data.source.IRoadRemote
import com.challenger.remote.utils.API_KEY
import io.reactivex.Single

class GetRoadStatusRemoteImpl(private val apiService: ApiService) : IRoadRemote {
    override fun getRoadStatus(roadName: String): Single<List <RoadInfoEntity>> {
        return apiService.getRoadInfo(roadName, API_KEY)
    }
}