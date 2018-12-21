package com.jcmsalves.londontubestatus.status.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jcmsalves.domain.status.GetLinesStatusInteractor
import com.jcmsalves.domain.status.model.StatusResult
import com.jcmsalves.londontubestatus.status.model.LineStatusToLineStatusPresentationMapper
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class StatusViewModel constructor(
    private val getLinesStatusInteractor: GetLinesStatusInteractor,
    private val mapper: LineStatusToLineStatusPresentationMapper
) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    var linesStatusLiveData: MutableLiveData<StatusState> = MutableLiveData()

    fun fetchLinesStatus() {
        linesStatusLiveData.postValue(StatusState.Loading)
        launch {
            val statusResult = withContext(Dispatchers.IO) { getLinesStatusInteractor.execute() }
            when (statusResult) {
                is StatusResult.Success -> {
                    val linesStatus = statusResult.linesStatus.map {
                        mapper.map(it)
                    }
                    linesStatusLiveData.postValue(StatusState.Data(linesStatus))
                }
                StatusResult.Error -> linesStatusLiveData.postValue(StatusState.Error)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
