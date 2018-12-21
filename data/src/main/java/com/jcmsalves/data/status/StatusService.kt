package com.jcmsalves.data.status

import com.jcmsalves.data.status.model.LineStatusModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface StatusService {
    @GET("Line/Mode/tube/Status")
    fun getStatus(): Deferred<List<LineStatusModel>>
}
