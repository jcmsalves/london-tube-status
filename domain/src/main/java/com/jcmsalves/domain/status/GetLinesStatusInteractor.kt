package com.jcmsalves.domain.status

import com.jcmsalves.codewarsapi.domain.RxSchedulers
import com.jcmsalves.domain.NoArgInteractor
import com.jcmsalves.domain.status.model.LineStatus
import io.reactivex.Observable

open class GetLinesStatusInteractor constructor(
    private val statusRepository: StatusRepository,
    private val rxSchedulers: RxSchedulers
) : NoArgInteractor<List<LineStatus>> {

    override fun execute(): Observable<List<LineStatus>> =
        statusRepository.getLinesStatus()
            .subscribeOn(rxSchedulers.io())
            .observeOn(rxSchedulers.main())
            .toObservable()
}