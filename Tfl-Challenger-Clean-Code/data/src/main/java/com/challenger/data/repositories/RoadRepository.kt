package com.challenger.data.repositories

import com.challenger.data.mappers.RoadEntityMapper
import com.challenger.data.source.IRoadDataStore
import com.challenger.domain.models.RoadInfo
import com.challenger.domain.repository.IRoadRepository
import io.reactivex.Single




class RoadRepository(private val roadRemoteDataSource: IRoadDataStore, private val roadEntityMapper: RoadEntityMapper) :
    IRoadRepository {

    override fun getRoadStatus(roadName: String): Single<RoadInfo> {
         return roadRemoteDataSource.getRoadStatus(roadName).map { roadInfoEntity->
              roadEntityMapper.mapFromRemote(roadInfoEntity.get(0))
         }
    }


}