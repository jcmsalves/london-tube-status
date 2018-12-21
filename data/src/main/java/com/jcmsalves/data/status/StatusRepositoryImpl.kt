package com.jcmsalves.data.status

import com.jcmsalves.data.status.model.LineStatusModelToLineStatusMapper
import com.jcmsalves.domain.status.StatusRepository
import com.jcmsalves.domain.status.model.StatusResult

class StatusRepositoryImpl constructor(
    private val statusService: StatusService,
    private val mapper: LineStatusModelToLineStatusMapper
) : StatusRepository {

    override suspend fun getLinesStatus(): StatusResult =
        try {
            val linesStatus = statusService.getStatus().await()
                .map { mapper.map(it) }
            StatusResult.Success(linesStatus)
        } catch (throwable: Throwable) {
            StatusResult.Error
        }
}
