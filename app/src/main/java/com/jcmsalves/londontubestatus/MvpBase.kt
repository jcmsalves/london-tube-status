package com.jcmsalves.londontubestatus

import io.reactivex.disposables.CompositeDisposable

interface MvpView

interface Presenter<V : MvpView> {

    fun attachView(mvpView: V?)

    fun detachView()
}

open class BasePresenter<T : MvpView> : Presenter<T> {

    var mvpView: T? = null
    val compositeDisposable = CompositeDisposable()
    val isViewAttached = mvpView != null

    override fun attachView(mvpView: T?) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null
        compositeDisposable.clear()
    }
}
