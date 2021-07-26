package com.challenger.domain.usercases.utils

import com.challenger.domain.models.RoadInfo


class RoadInfoFactory {

    companion object Factory {

        fun makeRoadInfoResponse(): RoadInfo {

            val roadInfoEntity: RoadInfo = RoadInfo(
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



    }


}