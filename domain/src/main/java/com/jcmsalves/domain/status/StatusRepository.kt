package com.jcmsalves.domain.status

import com.jcmsalves.domain.status.model.LineStatus
import io.reactivex.Single

interface StatusRepository {

    fun getLinesStatus(): Single<List<LineStatus>>
}
