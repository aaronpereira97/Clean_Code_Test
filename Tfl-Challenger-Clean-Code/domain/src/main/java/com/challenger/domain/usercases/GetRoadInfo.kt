package com.challenger.domain.usercases

import com.challenger.domain.models.RoadInfo
import com.challenger.domain.repository.IRoadRepository
import io.reactivex.Single
import com.challenger.domain.executor.PostExecutionThread
import com.challenger.domain.executor.ThreadExecutor
import com.challenger.domain.utils.OpenForTesting


@OpenForTesting
class GetRoadInfo(private val roadRepository: IRoadRepository,
                  threadExecutor: ThreadExecutor,
                  postExecutionThread: PostExecutionThread
): SingleUseCase<RoadInfo, String>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(roadName: String?): Single<RoadInfo> {
        return roadRepository.getRoadStatus(roadName = roadName!!)
    }




}