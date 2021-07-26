package com.challenger.remote


import com.challenger.data.models.RoadInfoEntity
import com.challenger.remote.utils.DataFactory
import com.challenger.remote.utils.RoadInfoFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
 class GetRoadStatusRemoteImplTest{
    private lateinit var apiService: ApiService
    private lateinit var getRoadStatusRemoteImpl: GetRoadStatusRemoteImpl

    @Before
    fun setup() {
        apiService = mock()
        getRoadStatusRemoteImpl = GetRoadStatusRemoteImpl(apiService)
    }

    @Test
    fun test_get_road_status_completes_not_errors() {
        stubWheneverThenReturn(Single.just(RoadInfoFactory.makeRoadInfoEntityListResponse(1)))

       val testObserver = getRoadStatusRemoteImpl.getRoadStatus(DataFactory.randomUuid()).test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

    @Test
    fun test_road_returns_data() {
        val roadInfoResponse = RoadInfoFactory.makeRoadInfoEntityListResponse(1)
        stubWheneverThenReturn( Single.just(roadInfoResponse))
        val testObserver = getRoadStatusRemoteImpl.getRoadStatus(DataFactory.randomUuid()).test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(roadInfoResponse)

    }

    private fun stubWheneverThenReturn(single: Single<List< RoadInfoEntity>>){
        whenever(apiService.getRoadInfo(any(), any()))
            .thenReturn(single)
    }

}