package com.jcmsalves.domain.status.model

sealed class StatusResult {
    data class Success(val linesStatus: List<LineStatus>) : StatusResult()
    object Error : StatusResult()
}