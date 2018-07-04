package com.jcmsalves.codewarsapi.domain

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestRxSchedulersImpl : RxSchedulers {

    override fun main(): Scheduler = Schedulers.trampoline()

    override fun single(): Scheduler = Schedulers.trampoline()

    override fun io(): Scheduler = Schedulers.trampoline()

    override fun computation(): Scheduler = Schedulers.trampoline()

    override fun trampoline(): Scheduler = Schedulers.trampoline()
}
