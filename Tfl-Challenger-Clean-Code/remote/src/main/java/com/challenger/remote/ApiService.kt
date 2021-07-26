package com.challenger.remote


import com.challenger.data.models.RoadInfoEntity
import com.challenger.remote.utils.*
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @GET(GET_ROAD_INFO)
     fun getRoadInfo(
        @Path(PATH_ROAD)  roadName:String,
        @Query(QUERY_API_KEY) apiKey: String
    ) : Single<List <RoadInfoEntity>>

}