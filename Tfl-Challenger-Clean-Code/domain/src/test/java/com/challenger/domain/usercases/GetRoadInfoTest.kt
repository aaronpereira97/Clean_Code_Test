package com.challenger.domain.usercases

import com.challenger.domain.executor.PostExecutionThread
import com.challenger.domain.executor.ThreadExecutor
import com.challenger.domain.models.RoadInfo
import com.challenger.domain.repository.IRoadRepository
import com.challenger.domain.usercases.utils.DataFactory
import com.challenger.domain.usercases.utils.RoadInfoFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetRoadInfoTest {
    private lateinit var getRoadInfo: GetRoadInfo
    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockGetRoadInfoRepository : IRoadRepository


    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockGetRoadInfoRepository = mock()

        getRoadInfo = GetRoadInfo(mockGetRoadInfoRepository, mockThreadExecutor, mockPostExecutionThread)
    }

    @Test
    fun get_road_info_use_case_calls_repository() {
        getRoadInfo.buildUseCaseObservable(DataFactory.randomUuid())
        //Verify that getInfoRoad was called
        verify(mockGetRoadInfoRepository).getRoadStatus(any())
    }


    @Test
    fun get_road_info_use_case_completes_without_errors() {
        stubWheneverThenReturn(Single.just(RoadInfoFactory.makeRoadInfoResponse()))
        val testObserver = getRoadInfo.buildUseCaseObservable(DataFactory.randomUuid()).test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

    @Test
    fun get_road_info_use_case_returns_data() {
        val roadInfo = RoadInfoFactory.makeRoadInfoResponse()
        stubWheneverThenReturn(Single.just(roadInfo))
        val testObserver = getRoadInfo.buildUseCaseObservable(DataFactory.randomUuid()).test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(roadInfo)
    }




    private fun stubWheneverThenReturn(single: Single<RoadInfo>){
        whenever(mockGetRoadInfoRepository.getRoadStatus(any()))
            .thenReturn(single)
    }
}