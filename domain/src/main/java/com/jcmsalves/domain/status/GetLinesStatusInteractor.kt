package com.jcmsalves.domain.status

import com.jcmsalves.domain.status.model.StatusResult

open class GetLinesStatusInteractor constructor(
    private val statusRepository: StatusRepository
) {
    suspend fun execute(): StatusResult {
        return statusRepository.getLinesStatus()
    }
}
