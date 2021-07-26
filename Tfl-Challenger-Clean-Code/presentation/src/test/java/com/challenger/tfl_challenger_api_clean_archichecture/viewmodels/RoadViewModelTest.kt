package com.challenger.tfl_challenger_api_clean_archichecture.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.challenger.data.models.RoadInfoEntity
import com.challenger.domain.models.RoadInfo
import com.challenger.domain.usercases.GetRoadInfo
import com.challenger.domain.usercases.utils.DataFactory
import com.challenger.domain.usercases.utils.RoadInfoFactory
import com.challenger.tfl_challenger_api_clean_archichecture.utils.Resource
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import java.lang.RuntimeException

@RunWith(JUnit4::class)
class RoadViewModelTest {
    private lateinit var mockGetRoadInfoUseCase: GetRoadInfo
    private lateinit var roadViewModel: RoadViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        mockGetRoadInfoUseCase = mock()
        roadViewModel = RoadViewModel(mockGetRoadInfoUseCase)
    }


    @Test
    fun `test_loading_is_emitted`() {
        stubWheneverThenReturn(Single.just(RoadInfoFactory.makeRoadInfoResponse()))
        roadViewModel.getRoadInfo(DataFactory.randomUuid())

        val mediatorLiveData = MediatorLiveData<Resource<RoadInfo>>()
        mediatorLiveData.addSource(roadViewModel.get_road_info) { result ->
             assertTrue ( result is Resource.Loading )
        }

    }

    @Test
    fun test_error_is_emitted() {
        stubWheneverThenReturn(Single.error(RuntimeException()))
        roadViewModel.getRoadInfo(DataFactory.randomUuid())

        val mediatorLiveData = MediatorLiveData<Resource<RoadInfo>>()
        mediatorLiveData.addSource(roadViewModel.get_road_info) { result ->
            assertTrue ( result is Resource.Error )
        }
    }

    @Test
    fun test_data_is_emitted_success() {
        val roadInfo = RoadInfoFactory.makeRoadInfoResponse()
        stubWheneverThenReturn(Single.just(roadInfo))
        roadViewModel.getRoadInfo(DataFactory.randomUuid())

        val mediatorLiveData = MediatorLiveData<Resource<RoadInfo>>()
        mediatorLiveData.addSource(roadViewModel.get_road_info) { result ->
            when(result) {
                is Resource.Success -> {
                   val getInfo = result.result
                    assertEquals(getInfo.displayName, roadInfo.displayName)
                    assertEquals(getInfo.id, roadInfo.id)
                    assertEquals(getInfo.type, roadInfo.type)
                    assertEquals(getInfo.statusSeverity, roadInfo.statusSeverity)
                    assertEquals(getInfo.statusSeverityDescription, roadInfo.statusSeverityDescription)
                    assertEquals(getInfo.bounds, roadInfo.bounds)
                    assertEquals(getInfo.url, roadInfo.url)
                    assertEquals(getInfo.envelope, roadInfo.envelope)
                }

            }

        }
    }

    private fun stubWheneverThenReturn(single: Single<RoadInfo>) {
        whenever(mockGetRoadInfoUseCase.buildUseCaseObservable(any()))
            .thenReturn(single)
    }

}