package com.jcmsalves.domain

import io.reactivex.Observable

interface InteractorRequest

interface Interactor<in REQUEST : InteractorRequest, RESULT> {
    fun execute(request: REQUEST): Observable<RESULT>

}

interface NoArgInteractor<RESULT> {
    fun execute(): Observable<RESULT>

}
