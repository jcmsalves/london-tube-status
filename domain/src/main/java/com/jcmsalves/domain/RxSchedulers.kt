package com.jcmsalves.codewarsapi.domain

import io.reactivex.Scheduler

interface RxSchedulers {

    fun main(): Scheduler

    fun single(): Scheduler

    fun io(): Scheduler

    fun computation(): Scheduler

    fun trampoline(): Scheduler
}
