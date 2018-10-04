package com.jcmsalves.londontubestatus.status.viewmodel

import com.jcmsalves.londontubestatus.status.model.LineStatusPresentation

sealed class StatusState {
    object Error : StatusState()
    object Loading : StatusState()
    data class Data(val linesStatus: List<LineStatusPresentation>) : StatusState()
}
