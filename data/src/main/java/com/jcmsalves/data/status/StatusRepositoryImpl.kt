package com.jcmsalves.data.status

import com.jcmsalves.data.status.model.LineStatusModelToLineStatusMapper
import com.jcmsalves.domain.status.StatusRepository
import com.jcmsalves.domain.status.model.LineStatus
import io.reactivex.Single
import javax.inject.Inject

class StatusRepositoryImpl @Inject constructor(
    private val statusService: StatusService,
    private val mapper: LineStatusModelToLineStatusMapper
) : StatusRepository {

    override fun getLinesStatus(): Single<List<LineStatus>> {
        return statusService.getStatus()
            .flattenAsObservable { it }
            .map { mapper.map(it) }
            .toList()
    }
}
