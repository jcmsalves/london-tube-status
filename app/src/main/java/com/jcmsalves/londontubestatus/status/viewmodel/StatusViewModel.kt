package com.jcmsalves.londontubestatus.status.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jcmsalves.domain.status.GetLinesStatusInteractor
import com.jcmsalves.londontubestatus.status.model.LineStatusToLineStatusPresentationMapper
import io.reactivex.disposables.CompositeDisposable

class StatusViewModel constructor(
    private val getLinesStatusInteractor: GetLinesStatusInteractor,
    private val mapper: LineStatusToLineStatusPresentationMapper
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var linesStatusLiveData: MutableLiveData<StatusState> = MutableLiveData()

    fun fetchLinesStatus() {
        compositeDisposable.add(getLinesStatusInteractor.execute()
            .doOnSubscribe {
                linesStatusLiveData.postValue(StatusState.Loading)
            }
            .flatMapIterable { it }
            .map { mapper.map(it) }
            .toList()
            .subscribe(
                { linesStatus ->
                    linesStatusLiveData.postValue(StatusState.Data(linesStatus))
                },
                {
                    linesStatusLiveData.postValue(StatusState.Error)
                }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
