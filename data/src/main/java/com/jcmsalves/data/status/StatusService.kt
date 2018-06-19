package com.jcmsalves.data.status

import com.jcmsalves.data.status.model.LineStatusModel
import io.reactivex.Single
import retrofit2.http.GET

interface StatusService {

    @GET("Line/Mode/tube/Status")
    fun getStatus(): Single<List<LineStatusModel>>
}
