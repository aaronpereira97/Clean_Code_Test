package com.challenger.data.mappers

import com.challenger.data.models.RoadInfoEntity
import com.challenger.domain.models.RoadInfo

class RoadEntityMapper : EntityMapper<RoadInfoEntity, RoadInfo> {
    override fun mapFromRemote(roadInfoEntity: RoadInfoEntity): RoadInfo {
        return RoadInfo(
            type = roadInfoEntity.type,
            displayName = roadInfoEntity.displayName,
            id = roadInfoEntity.id,
            statusSeverity = roadInfoEntity.statusSeverity,
            statusSeverityDescription = roadInfoEntity.statusSeverityDescription,
            bounds = roadInfoEntity.bounds,
            envelope = roadInfoEntity.envelope,
            url = roadInfoEntity.url
        )
    }




}