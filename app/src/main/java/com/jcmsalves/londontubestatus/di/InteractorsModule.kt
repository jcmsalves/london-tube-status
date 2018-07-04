package com.jcmsalves.londontubestatus.di

import com.jcmsalves.codewarsapi.domain.RxSchedulers
import com.jcmsalves.domain.status.GetLinesStatusInteractor
import com.jcmsalves.domain.status.StatusRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorsModule {

    @Provides
    fun providesGetLinesStatusInteractor(statusRepository: StatusRepository,
                                         rxSchedulers: RxSchedulers) =
        GetLinesStatusInteractor(statusRepository, rxSchedulers)
}
