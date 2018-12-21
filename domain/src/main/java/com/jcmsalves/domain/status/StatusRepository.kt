package com.jcmsalves.domain.status

import com.jcmsalves.domain.status.model.StatusResult

interface StatusRepository {

    suspend fun getLinesStatus(): StatusResult
}
