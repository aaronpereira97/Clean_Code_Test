package com.challenger.data.source

import com.challenger.data.models.RoadInfoEntity
import com.challenger.data.utils.DataFactory
import com.challenger.data.utils.RoadInfoFactory

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RoadRemoteDataStoreTest{
     private lateinit var roadRemote: IRoadRemote
     private lateinit var roadRemoteDataStore: RoadRemoteDataStore

    @Before
    fun setUp() {
        roadRemote = mock()
        roadRemoteDataStore = RoadRemoteDataStore(roadRemote)
    }

    @Test
    fun get_road_info_use_case_completes_without_errors() {
        stubWheneverThenReturn(Single.just(RoadInfoFactory.makeRoadInfoEntityListResponse(1)))
        val testObserver = roadRemoteDataStore.getRoadStatus(DataFactory.randomUuid()).test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

    @Test
    fun get_road_info_use_case_returns_data() {
        val roadInfoEntity = RoadInfoFactory.makeRoadInfoEntityListResponse(1)
        stubWheneverThenReturn(Single.just(roadInfoEntity))
        val testObserver = roadRemoteDataStore.getRoadStatus(DataFactory.randomUuid()).test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(roadInfoEntity)
    }


    private fun stubWheneverThenReturn(single: Single<List< RoadInfoEntity>>){
        whenever(roadRemote.getRoadStatus(any()))
            .thenReturn(single)
    }



}