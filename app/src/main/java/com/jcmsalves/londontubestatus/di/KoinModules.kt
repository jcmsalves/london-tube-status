package com.jcmsalves.londontubestatus.di

import com.jcmsalves.codewarsapi.domain.RxSchedulers
import com.jcmsalves.data.RxSchedulersImpl
import com.jcmsalves.data.status.StatusRepositoryImpl
import com.jcmsalves.data.status.model.LineStatusModelToLineStatusMapper
import com.jcmsalves.domain.status.GetLinesStatusInteractor
import com.jcmsalves.domain.status.StatusRepository
import com.jcmsalves.londontubestatus.status.LinesStatusAdapter
import com.jcmsalves.londontubestatus.status.model.LineStatusToLineStatusPresentationMapper
import com.jcmsalves.londontubestatus.status.presenter.StatusPresenter
import org.koin.dsl.module.module

val appModule = module {
    single<RxSchedulers> { RxSchedulersImpl() }
}

val viewsModule = module {
    factory { StatusPresenter(get(), get()) }
    factory { LinesStatusAdapter() }
}

val interactorsModule = module {
    factory { GetLinesStatusInteractor(get(), get()) }
}

val repositoryModule = module {
    single<StatusRepository> { StatusRepositoryImpl(get(), get()) }
}

val mappersModule = module {
    single { LineStatusModelToLineStatusMapper() }
    single { LineStatusToLineStatusPresentationMapper() }
}