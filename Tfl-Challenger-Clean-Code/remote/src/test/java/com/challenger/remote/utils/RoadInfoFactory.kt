package com.challenger.remote.utils

import com.challenger.data.models.RoadInfoEntity

class RoadInfoFactory {

    companion object Factory {

        fun makeRoadInfoEntityResponse(): RoadInfoEntity {

            val roadInfoEntity: RoadInfoEntity = RoadInfoEntity(
                type = DataFactory.randomUuid(),
                displayName = DataFactory.randomUuid(), id = DataFactory.randomUuid(),
                statusSeverity = DataFactory.randomUuid(),
                statusSeverityDescription = DataFactory.randomUuid(),
                bounds = DataFactory.randomUuid(),
                envelope = DataFactory.randomUuid(),
                url = DataFactory.randomUuid()

            );

            return roadInfoEntity
        }

       fun makeRoadInfoEntityListResponse(count: Int) : List<RoadInfoEntity>{
           val list = arrayListOf<RoadInfoEntity>()
           for (i in 0 until count){
               list.add(makeRoadInfoEntityResponse())
           }

           return list
       }

    }


}