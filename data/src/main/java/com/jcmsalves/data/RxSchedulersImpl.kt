package com.jcmsalves.data

import com.jcmsalves.codewarsapi.domain.RxSchedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RxSchedulersImpl @Inject constructor() : RxSchedulers {

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun single(): Scheduler = Schedulers.single()

    override fun io(): Scheduler = Schedulers.io()

    override fun computation(): Scheduler = Schedulers.computation()

    override fun trampoline(): Scheduler = Schedulers.trampoline()
}
