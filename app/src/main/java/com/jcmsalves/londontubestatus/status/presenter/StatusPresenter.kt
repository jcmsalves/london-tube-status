package com.jcmsalves.londontubestatus.status.presenter

import com.jcmsalves.domain.status.GetLinesStatusInteractor
import com.jcmsalves.londontubestatus.BasePresenter
import com.jcmsalves.londontubestatus.status.model.LineStatusToLineStatusPresentationMapper
import com.jcmsalves.londontubestatus.status.view.StatusView
import javax.inject.Inject

class StatusPresenter @Inject constructor(
    private val getLinesStatusInteractor: GetLinesStatusInteractor,
    private val mapper: LineStatusToLineStatusPresentationMapper
) : BasePresenter<StatusView>() {

    override fun attachView(mvpView: StatusView?) {
        super.attachView(mvpView)
        fetchLinesStatus()
    }

    fun fetchLinesStatus() {
        compositeDisposable.add(getLinesStatusInteractor.execute()
            .doOnSubscribe { mvpView?.showLoading(true) }
            .flatMapIterable { it }
            .map { mapper.map(it) }
            .toList()
            .doAfterTerminate { mvpView?.showLoading(false) }
            .subscribe(
                { linesStatus ->
                    mvpView?.showLinesStatus(linesStatus)
                },
                {
                    mvpView?.showError()
                }))
    }
}
