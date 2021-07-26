package com.challenger.tfl_challenger_api_clean_archichecture.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenger.domain.models.RoadInfo
import com.challenger.domain.usercases.GetRoadInfo
import com.challenger.tfl_challenger_api_clean_archichecture.utils.OpenForTesting
import com.challenger.tfl_challenger_api_clean_archichecture.utils.Resource
import com.google.gson.JsonParser
import io.reactivex.observers.DisposableSingleObserver
import retrofit2.HttpException

private const val TAG = "RoadViewModel"

@OpenForTesting
class RoadViewModel(private val getRoadInfoUseCase: GetRoadInfo) : ViewModel() {
    private val _get_road_info = MutableLiveData<Resource<RoadInfo>>()
    val get_road_info = _get_road_info


    fun getRoadInfo(roadName: String) {
        _get_road_info.postValue(Resource.Loading())
        getRoadInfoUseCase.execute(RoadSubscriber(), roadName)
    }

    private inner class RoadSubscriber : DisposableSingleObserver<RoadInfo>() {
        override fun onSuccess(roadInfo: RoadInfo) {
            _get_road_info.postValue(Resource.Success(roadInfo))
            Log.i(TAG, "REQUEST WAS SUCCESS")
        }

        override fun onError(e: Throwable) {
            val error: HttpException = e as HttpException
            val errorBody = error.response()?.errorBody()

            val errorJsonString = errorBody?.string()
            val message = JsonParser().parse(errorJsonString)
                .asJsonObject["message"]
                .asString

            _get_road_info.postValue(Resource.Error(message))
            Log.i(TAG, "ERROR DURING THE REQUEST: ${e.message}")
        }

    }

    override fun onCleared() {
        super.onCleared()
        getRoadInfoUseCase.dispose()
    }
}