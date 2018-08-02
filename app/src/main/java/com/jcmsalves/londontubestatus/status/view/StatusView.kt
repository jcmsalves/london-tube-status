package com.jcmsalves.londontubestatus.status.view

import com.jcmsalves.londontubestatus.MvpView
import com.jcmsalves.londontubestatus.status.model.LineStatusPresentation

interface StatusView : MvpView {

    fun showLoading(loading: Boolean)

    fun showLinesStatus(linesStatus: List<LineStatusPresentation>)

    fun showError()
}
