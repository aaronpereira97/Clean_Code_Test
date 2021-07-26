package com.challenger.data.mappers

import com.challenger.data.utils.RoadInfoFactory
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RoadEntityMapperTest{
    private lateinit var roadEntityMapper: RoadEntityMapper

    @Before
    fun setUp() {
        roadEntityMapper = RoadEntityMapper()
    }

    @Test
    fun test_map_from_road_entity_to_road() {
        val roadInfoEntity = RoadInfoFactory.makeRoadInfoEntityResponse()
        val roadInfo = roadEntityMapper.mapFromRemote(roadInfoEntity = roadInfoEntity)

        assertEquals(roadInfo.bounds, roadInfoEntity.bounds)
        assertEquals(roadInfo.id, roadInfoEntity.id)
        assertEquals(roadInfo.type, roadInfoEntity.type)
        assertEquals(roadInfo.statusSeverityDescription, roadInfoEntity.statusSeverityDescription)
        assertEquals(roadInfo.statusSeverity, roadInfoEntity.statusSeverity)
        assertEquals(roadInfo.displayName, roadInfoEntity.displayName)
        assertEquals(roadInfo.envelope, roadInfoEntity.envelope)
    }
}